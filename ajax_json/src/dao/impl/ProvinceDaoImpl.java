package dao.impl;

import dao.ProvinceDao;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/14 13:48
 */
public class ProvinceDaoImpl implements ProvinceDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> provinceList() {
        String sql = "SELECT * FROM province";
        List<Province> provinceList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return provinceList;
    }
}
