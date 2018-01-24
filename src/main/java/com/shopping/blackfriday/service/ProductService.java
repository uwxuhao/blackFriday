package com.shopping.blackfriday.service;

import com.shopping.blackfriday.dto.RequestResult;
import com.shopping.blackfriday.dto.ShoppingInfo;
import com.shopping.blackfriday.entity.Product;
import com.shopping.blackfriday.exception.NoSuchProductException;

import java.util.Date;
import java.util.List;

public interface ProductService {
    Product getProductById(long productId) throws NoSuchProductException;

    List<Product> getAllProducts();

    ShoppingInfo getShoppingInfo(long productId) throws NoSuchProductException;

    RequestResult doShopping(long productId, long userId, int num, String md5);

}
