package dao.impl;


import bean.PinLun;
import dao.PinLunDao;

import java.sql.SQLException;
import java.util.List;

public class PinLunDaoImpl implements PinLunDao {
    @Override
    public List<PinLun> selectPinLun(String id) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDS());
        try {
            return qr.query("select * from news_comment where newsid=?",new BeanListHandler<PinLun>(PinLun.class),id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int addPinLun(PinLun pinlun) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDS());
        Date date = new Date();
        try {
            return qr.update("insert into news_comment(newsid,content,author,createdate) values(?,?,?,?)",pinlun.getId(),pinlun.getContent(),pinlun.getAuthor(),date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delete(String id) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDS());
        try {
            qr.update("delete from news_comment where newsid=?",id);
            return qr.update("delete from news_detail where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

