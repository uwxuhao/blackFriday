package com.shopping.blackfriday.dao;

import com.shopping.blackfriday.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProductDao {
    int modifyInventoryNumber(@Param("productId") long id,@Param("orderTime") Date orderTime,@Param("num") int num);
    Product queryProductById(@Param("productId") long id);
    List<Product> queryAllProducts();
}
