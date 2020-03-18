package service;

import domain.Province;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/14 13:49
 */
public interface ProviceService {
    public List<Province> provinceList();
    String provinceRedis();
}
