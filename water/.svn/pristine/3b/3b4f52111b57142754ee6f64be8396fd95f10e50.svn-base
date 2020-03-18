package cn.msg.dao;

import cn.msg.domain.News;
import cn.msg.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 23:37
 */
@Repository
public interface NewsDao {


    /**
     * 查询总新闻数
     * @return
     */
    @Select("select count(*) from news")
    public Integer findTotalNewsCount();

    /**
     * 查询每页显示内容
     * @param start
     * @param pageSize
     * @return
     */
    @Select( "select nId,newsTitle,uploadDate,newsStatus,categoryName as newsCategory,newsSummary,newsText,newsUploadUId from news,newsstatus,newscategory where news.newsSId=newsstatus.newsSId and news.newsCId=newscategory.cId limit #{start},#{pageSize}")
    @Results(id = "newsMap",value = {
            @Result(id = true,column = "nId",property = "nId"),
            @Result(column = "newsTitle",property = "newsTitle"),
            @Result(column = "newsStatus",property = "newsStatus"),
            @Result(column = "newsCategory",property = "newsCategory"),
            @Result(column = "newsSummary",property = "newsSummary"),
            @Result(column = "newsText",property = "newsText"),
            @Result(column = "newsUploadUId",property = "newsUploadUId"),
            @Result(column = "newsUploadUId",property = "newsUploadUser",one = @One(select = "cn.msg.dao.UserDao.findOneUser",fetchType = FetchType.DEFAULT))
    })
    public List<News> findAllNews(@Param("start") int start, @Param("pageSize") int pageSize);

    /**
     * 删除新闻
     * @param nId
     */
    @Delete("delete from news where nId = #{nId}")
    void deleteNews(int nId);


    /**
     * 添加新闻
     * @param news
     * @return
     */
    @Insert("insert into news(newsTitle,uploadDate,newsSId,newsUploadUId,newsCId,newsSummary,newsText) values (#{newsTitle},#{uploadDate},#{newsStatus},#{newsUploadUId},#{newsCategory},#{newsSummary},#{newsText})")
    boolean addNews(News news);
}
