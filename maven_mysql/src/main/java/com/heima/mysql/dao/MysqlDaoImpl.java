package com.heima.mysql.dao;

import com.heima.mysql.dao.impl.MysqlDao;
import com.heima.mysql.domain.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/14 22:22
 */
public class MysqlDaoImpl implements MysqlDao {
    public List<Province> findAll() {
        List<Province> provinceList = new ArrayList<Province>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/redistest","root","root");
            String sql = "select * from province";
            PreparedStatement psm = connection.prepareStatement(sql);
            ResultSet resultSet = psm.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Province province = new Province();
                province.setId(id);
                province.setName(name);
                provinceList.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provinceList;
    }
}
