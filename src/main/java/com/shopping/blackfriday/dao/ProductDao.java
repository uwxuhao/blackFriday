package com.shopping.blackfriday.dao;

import com.shopping.blackfriday.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProductDao {
    int modifyInventoryNumber(@Param("productId") long ProductId,@Param("orderTime") Date orderTime,@Param("num") int num);
    Product queryProductById(@Param("productId") long ProductId);
    List<Product> queryAllProducts();
}
