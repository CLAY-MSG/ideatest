package cn.msg.service.impl;

import cn.msg.dao.NewsDao;
import cn.msg.domain.News;
import cn.msg.domain.PageBean;
import cn.msg.domain.User;
import cn.msg.service.NewsService;
import cn.msg.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 23:38
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public PageBean<News> findAllNews(int currentPage, int pageSize) {
        PageBean<News> newsPageBean = new PageBean<News>();
        Integer totalNewsCount = newsDao.findTotalNewsCount();
        newsPageBean.setTotalCount(totalNewsCount);
        newsPageBean.setCurrentPage(currentPage);
        newsPageBean.setPageSize(pageSize);
        int totalPage = totalNewsCount % pageSize == 0 ? totalNewsCount/pageSize : (totalNewsCount/pageSize)+1;
        newsPageBean.setTotalPage(totalPage);
        int start = (currentPage-1)*pageSize;
        List<News> newsList = newsDao.findAllNews(start, pageSize);
        for (News news : newsList) {
            System.out.println(news.getUploadDate()+"--------");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                news.setUploadDate(sdf.parse(sdf.format(news.getUploadDate())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(news.getUploadDate());
        }
        newsPageBean.setPageContent(newsList);
        System.out.println(newsList.get(1));
        return newsPageBean;
    }

    @Override
    public void deleteNews(String nId) {
        newsDao.deleteNews(Integer.parseInt(nId));
    }

    @Override
    public boolean addNews(News news) {
        return newsDao.addNews(news);
    }
}
