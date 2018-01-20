package com.shopping.blackfriday.dao;

import com.shopping.blackfriday.entity.ShoppingRecord;

import java.util.List;

public interface ShoppingRecordDao {
    int insertShoppingRecord(long userId, long productId, int num);

    List<ShoppingRecord> queryShoppingRecordByUserId(long userId);

    List<ShoppingRecord> queryShoppingRecordByProductId(long productId);

    ShoppingRecord queryShoppingRecordByUserAndProduct(long userId, long productId);




}
