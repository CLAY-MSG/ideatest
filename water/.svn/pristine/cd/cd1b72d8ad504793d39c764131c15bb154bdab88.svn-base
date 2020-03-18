package cn.msg.controller;

import cn.msg.domain.News;
import cn.msg.domain.PageBean;
import cn.msg.domain.ResultInfo;
import cn.msg.domain.User;
import cn.msg.service.NewsService;
import cn.msg.service.UserService;
import cn.msg.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 22:39
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/newsList")
    public @ResponseBody PageBean<News> findAllNews(String currentPage, String pageSize){
        int currentPageInt;
        if (currentPage != null && currentPage.length() != 0) {
            currentPageInt = Integer.parseInt(currentPage);
        } else {
            currentPageInt = 1;
        }
        int pageSizeInt;
        if (pageSize != null && pageSize.length() != 0) {
            pageSizeInt = Integer.parseInt(pageSize);
        } else {
            pageSizeInt = 5;
        }
        return newsService.findAllNews(currentPageInt, pageSizeInt);
    }
    @RequestMapping("/deleteNews")
    public @ResponseBody String deleteNews(String nId){
        newsService.deleteNews(nId);
        return "删除成功";
    }
    @RequestMapping("/addNews")
    public @ResponseBody ResultInfo addNews(HttpServletRequest request,String newsUploadUId, String newsTitle, String newsImg, String newsCategory, String newsSummary, String newsText){
        System.out.println(newsText);
        News news = new News();
        news.setNewsTitle(newsTitle);
        news.setUploadDate(new Date());
        news.setNewsImg(null);
        news.setNewsCategory(newsCategory);
        news.setNewsUploadUId(newsUploadUId);
        news.setNewsStatus(newsCategory);
        news.setNewsSummary(newsSummary);
        String basePath = request.getSession().getServletContext().getRealPath("/uploads");
        String dataPath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File dir = new File(basePath+"/"+dataPath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        String fileName = UuidUtil.getUuid()+newsTitle;
        File file = new File(dir, fileName+".txt");
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            byte[] bytes = newsText.getBytes(StandardCharsets.UTF_8);
            bufferedOutputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        news.setNewsText(file.getAbsolutePath());
        boolean flag = newsService.addNews(news);
        ResultInfo resultInfo = new ResultInfo();
        if (flag){
            resultInfo.setFlag(true);
            resultInfo.setData("保存成功");
        }else {
            resultInfo.setFlag(false);
            resultInfo.setData("保存失败，请重新尝试");
        }
        return resultInfo;
    }

}
