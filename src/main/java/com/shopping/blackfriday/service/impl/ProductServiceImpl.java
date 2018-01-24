package com.shopping.blackfriday.service.impl;

import com.shopping.blackfriday.dao.ProductDao;
import com.shopping.blackfriday.dao.ShoppingRecordDao;
import com.shopping.blackfriday.dto.RequestResult;
import com.shopping.blackfriday.dto.ShoppingInfo;
import com.shopping.blackfriday.entity.Product;
import com.shopping.blackfriday.enums.ShoppingStateEnum;
import com.shopping.blackfriday.exception.NoSuchProductException;
import com.shopping.blackfriday.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ShoppingRecordDao shoppingRecordDao;

    private final String salt = "vUrWAi$glEiozmDGYjoLPTX#9aW1U3B8";

    public Product getProductById(long productId) throws NoSuchProductException {
        Product product = productDao.queryProductById(productId);
        if (product == null) {
            throw new NoSuchProductException("The product id: " + productId + " dose not exist in data base ");
        } else return product;
    }

    public List<Product> getAllProducts() {
        return productDao.queryAllProducts();
    }

    public ShoppingInfo getShoppingInfo(long productId) throws NoSuchProductException {
        Product product = getProductById(productId);
        Date startTime = product.getStartTime();
        Date endTime = product.getEndTime();
        Date curTime = new Date();
        if (startTime.getTime() > curTime.getTime() || endTime.getTime() < curTime.getTime()) {
            return new ShoppingInfo(false, null, productId, curTime, startTime, endTime);
        } else {
            return new ShoppingInfo(true, getMD5(productId), productId, curTime, startTime, endTime);
        }

    }

    @Transactional
    public RequestResult doShopping(long productId, long userId, int num, String md5) {

        Date curTime = new Date();
        int affectRows = productDao.modifyInventoryNumber(productId, curTime, num);
        if (affectRows > 0) {
            // do shopping successfully
            shoppingRecordDao.insertShoppingRecord(userId, productId, curTime, num);
            return new RequestResult(ShoppingStateEnum.SUCCESS);
        } else {
            Product product = getProductById(productId);
            if (product.getEndTime().getTime() <= curTime.getTime()) {
                // end time
                return new RequestResult(ShoppingStateEnum.END);
            } else if (md5 == null || !getMD5(productId).equals(md5)) {
                return new RequestResult(ShoppingStateEnum.WRONG_MD5);
            } else if (product.getInventory() < num) {
                // not enough inventory
                return new RequestResult(ShoppingStateEnum.NOT_ENOUGH);
            } else {
                return new RequestResult(ShoppingStateEnum.INNER_ERROR);
            }
        }
    }

    private String getMD5(long productId) {
        String base = productId + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

}
