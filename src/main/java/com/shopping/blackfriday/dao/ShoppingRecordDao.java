package com.shopping.blackfriday.dao;

import com.shopping.blackfriday.entity.ShoppingRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ShoppingRecordDao {
    int insertShoppingRecord(@Param("userId") long userId, @Param("productId") long productId, @Param("create_time") Date createTime, @Param("num") int num);

    List<ShoppingRecord> queryShoppingRecordByUserId(@Param("userId") long userId);

    List<ShoppingRecord> queryShoppingRecordByProductId(@Param("productId") long productId);

    List<ShoppingRecord> queryShoppingRecordByUserAndProduct(@Param("userId") long userId, @Param("productId") long productId);
}
