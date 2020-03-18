package com.heima.mysql.dao.impl;

import com.heima.mysql.domain.Province;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/14 22:22
 */
public interface MysqlDao {
    public List<Province> findAll();
}
