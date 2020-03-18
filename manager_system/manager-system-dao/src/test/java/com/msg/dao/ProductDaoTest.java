package com.msg.dao;

import com.msg.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/9 14:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})
public class ProductDaoTest {

    /*public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(ProductDao.class.getClassLoader().getResourceAsStream("spring/oraclejdbc.properties"));
        String driverClassName = properties.getProperty("driverClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        Class.forName(driverClassName);
        Connection connection = DriverManager.getConnection(url,username,password);
        String sql = "select * from product";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String productname = resultSet.getString("PRODUCTNAME");
            System.out.println(productname);
        }
    }*/

    @Autowired
    ProductDao productDao;

    @Test
    public void testFindAllProduct(){
        System.out.println(productDao.findAllProduct());
    }

    @Test
    public void testFindOneProductById(){
        System.out.println(productDao.findOneProductById("A628E1B0BC1C494BAE87810220E935ED"));
    }
}
