# A website for Black Friday shopping
Technology: Spring + SpringMVC + Mybatis, MySQL, Maven, JQuery

Inspired by [@geekyijun](https://github.com/geekyijun/seckill)

## Entity
The class in Entity is used to represent the tuple in the database. For now, two entity classes are implemented. The `Product` is used to represent the products that customers can buy. The `shoppingRecord` is used to represent the shopping record created by each shopping operation.

## Dao
The class in Dao is interface between Java and data base. `ProductDao` is used to modify the number of products and fetch the information of products. `ShoppingRecordDao` is used to insert Shopping records into data base and fetch the records. 

Dao is only the first part for the interaction between Java and MySQL. There are some other important steps.
* The file `jdbc.properties`, is used to store the basic information to login in MySQL. It contains `driver`, `url` of the data base connection, `username` in the database and the `password` for the user.
* The file `mybatis-config.xml`, is used to store the configuration for MyBatis. The configurations like `mapUnderscoreToCamelCase` are stored in this file.
* The file `spring-dao.xml`, is used to configure the spring and the data base. It defines some beans for the configuration.
    - dataSource: Used to configure the connection to data base. It loaded the configuration of `driver`, `url`, `username` and `password` from the `jdbc.properties`.
    - sqlSessionFactory: Assign the dataSource as one property. Load the file `mybatis-config.xml` as the configuration for myBatis. Assign the entities and the mappers.
    - MapperScannerConfigurer: Used to scan all the Dao files. Load the sqlSessionFactory. Implement all the interface in Dao files using sqlSessionFactory, and inject into the container.
* The file `ProductDao.xml` and `ShoppingRecordDao.xml`, is used to store all the concrete SQL to implement the Dao interface.


