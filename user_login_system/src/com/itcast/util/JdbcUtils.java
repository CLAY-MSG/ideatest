package com.itcast.util;

import com.alibaba.druid.pool.DruidDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author CLAY
 * @Date 2020/1/7 10:35
 * @Version 1.1
 **/
public class JdbcUtils {
    /**MySQL数据库配置的JNDI数据源连接名，java:comp/env是必须加的,后面跟的是DataSource名*/
    private static final String MYSQL_DB_JNDINAME = "java:comp/env/jdbc/MysqlDataSource";
    private static DruidDataSource dsMySql = null;
    static{
        try {
            //1、初始化名称查找上下文
            Context ctx = new InitialContext();
            //2、通过JNDI名称找到DataSource
            dsMySql = (DruidDataSource) ctx.lookup(MYSQL_DB_JNDINAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public static DataSource getMysqlDataSource(){
        return dsMySql;
    }

    /**
     * MethodName: getMySqlConnection
     * Description: 获取MySQL数据库连接
     * @author CLAY
     * @return
     * @throws SQLException
     */
    public static Connection getMySqlConnection() throws SQLException {
        return dsMySql.getConnection();
    }


    /**
     * @Method: release
     * @Description: 释放资源，
     *     要释放的资源包括Connection数据库连接对象，负责执行SQL命令的Statement对象，存储查询结果的ResultSet对象
     * @Anthor:孤傲苍狼
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try{
                //关闭Connection数据库连接对象
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

