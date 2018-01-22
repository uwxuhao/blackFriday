package com.shopping.blackfriday.service;

import com.shopping.blackfriday.dto.RequestResult;
import com.shopping.blackfriday.dto.ShoppingInfo;
import com.shopping.blackfriday.entity.Product;

import java.util.Date;
import java.util.List;

public interface ProductService {
    Product getProductById(long productId);

    List<Product> getAllProducts();

    ShoppingInfo getShoppingInfo(long productId);

    RequestResult doShopping(long productId, long userId, String md5);

}
