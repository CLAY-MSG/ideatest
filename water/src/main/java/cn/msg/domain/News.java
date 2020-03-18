package cn.msg.domain;

import java.util.Date;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 22:58
 */
public class News {
    /**
     * 新闻Id
     */
    private Integer nId;
    /**
     * 新闻标题
     */
    private String newsTitle;
    /**
     * 新闻上传时间
     */
    private Date uploadDate;
    /**
     * 新闻状态
     */
    private String newsStatus;

    /**
     * 新闻上传者Id
     */
    private String newsUploadUId;
    /**
     * 新闻上传者
     */
    private User newsUploadUser;
    /**
     * 新闻分类
     */
    private String newsCategory;
    /**
     * 新闻摘要
     */
    private String newsSummary;
    /**
     * 新闻正文
     */
    private String newsText;
    /**
     * 新闻图片
     */
    private List<NewsImg> newsImg;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(String newsStatus) {
        this.newsStatus = newsStatus;
    }

    public String getNewsUploadUId() {
        return newsUploadUId;
    }

    public void setNewsUploadUId(String newsUploadUId) {
        this.newsUploadUId = newsUploadUId;
    }

    public User getNewsUploadUser() {
        return newsUploadUser;
    }

    public void setNewsUploadUser(User newsUploadUser) {
        this.newsUploadUser = newsUploadUser;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory;
    }

    public String getNewsSummary() {
        return newsSummary;
    }

    public void setNewsSummary(String newsSummary) {
        this.newsSummary = newsSummary;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public List<NewsImg> getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(List<NewsImg> newsImg) {
        this.newsImg = newsImg;
    }

    @Override
    public String toString() {
        return "News{" +
                "nId=" + nId +
                ", newsTitle='" + newsTitle + '\'' +
                ", uploadDate=" + uploadDate +
                ", newsStatus='" + newsStatus + '\'' +
                ", newsUploadUserId='" + newsUploadUId + '\'' +
                ", newsUploadUser=" + newsUploadUser +
                ", newsCategory='" + newsCategory + '\'' +
                ", newsSummary='" + newsSummary + '\'' +
                ", newsText='" + newsText + '\'' +
                ", newsImg=" + newsImg +
                '}';
    }
}
