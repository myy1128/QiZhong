package com.example.myy.qizhong;

import com.example.myy.qizhong.dao.DaoMaster;
import com.example.myy.qizhong.dao.DaoSession;
import com.example.myy.qizhong.dao.DbBeanDao;

import java.util.List;

public class DbUtil {

    private final DbBeanDao dbBeanDao;

    public DbUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getApp(), "aaa.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        dbBeanDao = daoSession.getDbBeanDao();
    }
    public static DbUtil dbUtil;

    public static DbUtil getDbUtil() {
        if (dbUtil==null){
            synchronized (DbUtil.class){
                if (dbUtil==null){
                    dbUtil = new DbUtil();
                }
            }
        }
        return dbUtil;
    }
    public void insert(DbBean dbBean){
        dbBeanDao.insertOrReplace(dbBean);
    }
    public List<DbBean> query(){
        List<DbBean> list = dbBeanDao.queryBuilder().list();
        return list;
    }
}
