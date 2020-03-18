package com.itcast.domain;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/8 21:48
 */
public class PageBean<T> {
    private int totalCount;
    private int totalPage;
    private int rows;
    private int currentPage;
    private List<T> list;

    public PageBean() {
    }

    public PageBean(int totalCount, int totalPage, int rows, int currentPage, List<T> list) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.rows = rows;
        this.currentPage = currentPage;
        this.list = list;
    }

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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", rows=" + rows +
                ", currentPage=" + currentPage +
                ", list=" + list +
                '}';
    }
}
