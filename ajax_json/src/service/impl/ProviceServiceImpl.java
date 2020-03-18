package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import redis.clients.jedis.Jedis;
import service.ProviceService;
import utils.JedisPoolUtils;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/14 13:52
 */
public class ProviceServiceImpl implements ProviceService {
    ProvinceDao pd = new ProvinceDaoImpl();

    @Override
    public List<Province> provinceList() {
        return pd.provinceList();
    }

    @Override
    public String provinceRedis() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String provinces = jedis.get("provinces");
        if (provinces == null || "".equals(provinces)) {
            List<Province> provinceList = pd.provinceList();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                provinces = objectMapper.writeValueAsString(provinces);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("provinces", provinces);
            jedis.close();
        }
        return provinces;
    }

}
