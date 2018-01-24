# A website for Black Friday shopping
Technology: Spring + SpringMVC + Mybatis, MySQL, Maven, JQuery

Inspired by [@geekyijun](https://github.com/geekyijun/seckill)

## Entity
The class in Entity is used to represent the tuple in the database. For now, two entity classes are implemented. The `Product` is used to represent the products that customers can buy. The `shoppingRecord` is used to represent the shopping record created by each shopping operation.

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


