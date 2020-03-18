package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;
import service.ProviceService;
import service.impl.ProviceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/14 13:49
 */
@WebServlet("/FindProvinceServlet")
public class FindProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        ProviceService ps = new ProviceServiceImpl();
        List<Province> provinceList = ps.provinceList();
        String provinceRedis = ps.provinceRedis();
        ObjectMapper objectMapper = new ObjectMapper();
        String provinces = objectMapper.writeValueAsString(provinceList);
//        response.getWriter().write(provinces);
        response.getWriter().write(provinceRedis);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
