package com.shopping.blackfriday.service.impl;

import com.shopping.blackfriday.dao.ProductDao;
import com.shopping.blackfriday.dao.ShoppingRecordDao;
import com.shopping.blackfriday.dto.RequestResult;
import com.shopping.blackfriday.dto.ShoppingInfo;
import com.shopping.blackfriday.entity.Product;
import com.shopping.blackfriday.exception.NoSuchProductException;
import com.shopping.blackfriday.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ShoppingRecordDao shoppingRecordDao;

    private final String salt = "vUrWAi$glEiozmDGYjoLPTX#9aW1U3B8";

    public Product getProductById(long productId) {
        return productDao.queryProductById(productId);
    }

    public List<Product> getAllProducts() {
        return productDao.queryAllProducts();
    }

    public ShoppingInfo getShoppingInfo(long productId) throws NoSuchProductException {
        Product product = getProductById(productId);
        if (product == null) {
            throw new NoSuchProductException("The product id: " + productId + " dose not exist in data base ");
        } else {
            Date startTime = product.getStartTime();
            Date endTime = product.getEndTime();
            Date curTime = new Date();
            if (startTime.getTime() > curTime.getTime() || endTime.getTime() < curTime.getTime()) {
                return new ShoppingInfo(false, null, productId, curTime, startTime, endTime);
            } else {
                return new ShoppingInfo(true, getMD5(productId), productId, curTime, startTime, endTime);
            }
        }
    }

    public RequestResult doShopping(long productId, long userId, int num, String md5) {
        return null;
    }

    private String getMD5(long productId) {
        String base = productId + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

}
