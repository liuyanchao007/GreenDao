package com.liu.bawei.greendao;

import android.util.Log;

import com.liu.bawei.greendao.gen.ShopDao;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/1/15.
 */

public class LoveDao {
    //添加数据,如果有重复则覆盖
    public static void insertLove(Shop shop){
        BaseApplication.getDaoInstance().getShopDao().insert(shop);
        Log.i(TAG, "insertLove: "+ BaseApplication.getDaoInstance().getShopDao().insertOrReplace(shop));
    }
    //更新数据
    public static void updateLove(Shop shop){
        BaseApplication.getDaoInstance().getShopDao().update(shop);
    }

    //删除数据
    public static void deleteLove(Long id){
        BaseApplication.getDaoInstance().getShopDao().deleteByKey(id);
    }

    //查询收藏的数据(即查询条件为Type=TYPE_LOVE的数据)
    public static List<Shop> queryLove(){

        return  BaseApplication.getDaoInstance().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE)).list();
    }

}
