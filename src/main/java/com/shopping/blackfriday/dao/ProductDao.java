package com.shopping.blackfriday.dao;

import com.shopping.blackfriday.entity.Product;

import java.util.Date;
import java.util.List;

public interface ProductDao {
    int modifyInventoryNumber(long id, Date orderDate, int num);
    Product queryProductById(long id);
    List<Product> queryAllProduct();
}
