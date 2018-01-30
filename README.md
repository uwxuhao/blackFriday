# A website for Black Friday shopping
Technology: Spring + SpringMVC + Mybatis, MySQL, Maven, JQuery

Inspired by [@geekyijun](https://github.com/geekyijun/seckill)

## Entity
The class in Entity is used to represent the tuple in the database. For now, two entity classes are implemented. The `Product` is used to represent the products that customers can buy. The `ShoppingRecord` is used to represent the shopping record created by each shopping operation. The `User` is used to represent a uesr.

## Dao
The interface in Dao is interface between Java and data base. `ProductDao` is used to modify the number of products and fetch the information of products. `ShoppingRecordDao` is used to insert Shopping records into data base and fetch the records. 

Dao interface is the first part for the interaction between Java and MySQL. There are some other important steps.
* The file `jdbc.properties`, is used to store the basic information to login in MySQL. It contains `driver`, `url` of the data base connection, `username` in the database and the `password` for the user.
* The file `mybatis-config.xml`, is used to store the configuration for MyBatis. The configurations like `mapUnderscoreToCamelCase` are stored in this file.
* The file `spring-dao.xml`, is used to configure the spring and the data base. It defines some beans for the configuration.
    - dataSource: Used to configure the connection to data base. It loaded the configuration of `driver`, `url`, `username` and `password` from the `jdbc.properties`.
    - sqlSessionFactory: Assign the dataSource as one property. Load the file `mybatis-config.xml` as the configuration for myBatis. Assign the entities and the mappers.
    - MapperScannerConfigurer: Used to scan all the Dao files. Load the sqlSessionFactory. Implement all the interface in Dao files using sqlSessionFactory, and inject into the container.
* The file `ProductDao.xml` and `ShoppingRecordDao.xml`, is used to store all the concrete SQL to implement the Dao interface.

### Test on Dao module
On each test class of Dao, 
```java
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
```
The annotation is used to load everything for spring, MySQL and Mybatis.

## Service
Service module works between the control part and the model part. The business logic is implemented in service module. The service uses the API provided by Dao to fetch the data, provides entity instance, checks whether the request from user is valid(the order number for a product should be less than the inventory number...) and provides md5 based on the product.

There are two service in the project.   
`ProductService` is the service to provide and modify `Product`. `Product getProductById(long productId)` can provide a `Product` instance. `ShoppingInfo getShoppingInfo(long productId)` provides a `ShoppingInfo` instance. The `ShoppingInfo` contains the `productId` of a `Product`. It also contains all the information that is necessary for the `Product` to be used at web module. The `ShoppingInfo` contains the md5 of a product. The md5 can be used as part of the link to order the product. If the md5 is wrong in the link, then the request of the product will fail.  
`UserService` is the service to provide the `User` instance and modify the user information. For the `ResponseUser login(String userName, String password)`, it will first check whether the the `userName` and `password` is valid. Then update the last login time of the user, and send an object `ResponseUser` which containing the information(exclude password and other secret information) of the user.

For the service module, the file `spring-service.xml` is created for the Spring configuration. Unlike the Dao-Spring configuration, for service,
```xml
<context:component-scan base-package="com.shopping.blackfriday.service"/>
```
`component-scan` is used to load the implementation of the beans. Because in the service module, there is a method `doShopping`, which may insert a record in the `ShoppingRecord` table, so, the `@Transactional` is needed for the method. 

### Test on Service module
For the test, because the service module will use the bean of `ProductService`, and the `ProductService` is based on Dao, so, the configuration for service and Dao is required. 
```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
```
## Web
The web module is composed of 3 parts. Controller, JSP and JavaScript. 

In `web.xml`, the dispatcher servlet is configured. 
```xml
<servlet>
        <servlet-name>main-dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- Load all the spring configuration files -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring/*.xml</param-value>
        </init-param>
</servlet>
```
It will load all the spring configuration for the dispatcher servlet, and map all the links to this servlet.   
The configuration in file `spring-web.xml` will let the container to scan `com.shopping.blackfriday.web`, where the controller class is defined.  
For the Controller, 2 annotations are needed.
```java
@Controller
@RequestMapping("/blackFriday")
```
The _@Controller_ will tell the container that the `BlackFridayController` is a bean needs to inject. The _@RequestMapping_ gives part of the URL to send request to the controller. When the controller receives a request, it will call one of the function to deal with that request according to the URL. The URL _/blackFriday/list_ and the _/blackFriday/{productId}/detail_ will return JSP to the client. The `Model` can be used to share variables between the controller and the JSP.  
For other functions, they will return a JSON. To return JSON, _@ResponseBody_ is needed. `public String login(@RequestBody LoginInfo loginInfo, HttpSession session)` will get the login information provided by the client which containing user name and password. It will call the `UserService` bean to check the validation of the user information. If the information is valid, the user name will be put into `HttpSession`. `ServerResponse` class is used for the return JSON information of each function in the controller. The `ServerResponse` has 3 fields:
```java
private T data;
private boolean success;
private String message;
```
The `data` contains the concrete object that will be return to the client. `success` indicates whether the request if valid. `message` will contains the information for the fail of the request.  
When the `ServerResponse` instance is created, a `ObjectMapper`, which is from _com.fasterxml.jackson_ will be used to convert the instance into a JSON string. Then the string will be returned. 
