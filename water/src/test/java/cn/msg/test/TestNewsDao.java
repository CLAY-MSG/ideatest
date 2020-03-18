package cn.msg.test;

import cn.msg.dao.NewsDao;
import cn.msg.domain.News;
import cn.msg.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/25 17:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestNewsDao {
    @Autowired
    private NewsDao newsDao;
    @Autowired
    private NewsService newsService;
    @Test
    public void testFindAllNews() throws IOException {
        List<News> allNews = newsDao.findAllNews(0, 10);
        System.out.println(allNews);

    }
    @Test
    public void testAddNews() throws IOException {
        News news = new News();
        news.setNewsTitle("newsTitle");
        news.setUploadDate(new Date());
        news.setNewsStatus("2");
        news.setNewsUploadUId("10");
        news.setNewsCategory("2");
        news.setNewsSummary("newsSummary");
        news.setNewsText("newsText");
        newsDao.addNews(news);
    }

    @Test
    public void testMethod(){
        newsService.findAllNews(1,10);
    }
}
