package com.heima.mysql.test;
import com.heima.mysql.dao.MysqlDaoImpl;
import com.heima.mysql.dao.impl.MysqlDao;
import com.heima.mysql.domain.Province;
import org.junit.Test;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/14 22:30
 */
public class DaoTest {
    @Test
    public void daoTest(){
        MysqlDao md = new  MysqlDaoImpl();
        List<Province> all = md.findAll();
        System.out.println(all);
    }
}
