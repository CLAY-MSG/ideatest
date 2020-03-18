package cn.msg.domain;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/25 21:22
 */
public class PageBean<T> {
    /**
     * 总记录条数
     */
    private int totalCount;
    /**
     * 页面总数
     */
    private int totalPage;
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 每页显示条数
     */
    private int pageSize;
    /**
     * 页面显示内容
     */
    private List<T> pageContent;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getPageContent() {
        return pageContent;
    }

    public void setPageContent(List<T> pageContent) {
        this.pageContent = pageContent;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", pageContent=" + pageContent +
                '}';
    }
}
