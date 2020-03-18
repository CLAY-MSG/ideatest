package test;

import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import org.junit.Test;
import service.ProviceService;
import service.impl.ProviceServiceImpl;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/14 14:24
 */
public  class DaoTest {
    @Test
    public void test1(){
        ProviceService ps = new ProviceServiceImpl();
        List<Province> provinces = ps.provinceList();
        System.out.println(provinces);
    }
}
