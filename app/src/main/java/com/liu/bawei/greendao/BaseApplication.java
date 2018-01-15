package com.liu.bawei.greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.liu.bawei.greendao.gen.DaoMaster;
import com.liu.bawei.greendao.gen.DaoSession;

/**
 * Created by Administrator on 2018/1/15.
 */

public class BaseApplication extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }
    /**
     * 配置数据库
     */
    private void setupDatabase(){
        //创建数据库shop.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"shop.db",null);
        //获取可写的数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstance(){
        return  daoSession;
    }
}
