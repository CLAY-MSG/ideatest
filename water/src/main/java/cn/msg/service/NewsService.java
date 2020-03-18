package cn.msg.service;

import cn.msg.domain.News;
import cn.msg.domain.PageBean;
import cn.msg.domain.User;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 23:38
 */
public interface NewsService {

    /**
     * 查询所有用户信息
     * @return
     */
    public PageBean<News> findAllNews(int currentPage, int pageSize);

    /**
     * 删除新闻
     * @param nId
     */
    void deleteNews(String nId);

    /**
     * 新建新闻
     *
     * @param news
     * @return
     */
     boolean addNews(News news);


}
