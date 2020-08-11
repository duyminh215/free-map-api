package com.duyminh215.map.paging;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PagingInfo<T> {
    protected int size;
    protected int totalElement;
    protected int totalPage;
    protected int currentPage;
    protected String nextPageURL;
    protected String previousPageURL;
    protected List<T> contents;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(int totalElement) {
        this.totalElement = totalElement;
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

    public String getNextPageURL() {
        return nextPageURL;
    }

    public void setNextPageURL(String nextPageURL) {
        this.nextPageURL = nextPageURL;
    }

    public String getPreviousPageURL() {
        return previousPageURL;
    }

    public void setPreviousPageURL(String previousPageURL) {
        this.previousPageURL = previousPageURL;
    }

    public List<T> getContents() {
        return contents;
    }

    public void setContents(List<T> contents) {
        this.contents = contents;
    }

    public void loadFromPageable(Pageable pageable) {
        this.size = pageable.getPageSize();
        this.currentPage = pageable.getPageNumber();
    }

    public void loadFromPage(Page page) {
        this.totalElement = (int) page.getTotalElements();
        this.totalPage = page.getTotalPages();
    }

    public PagingInfo<T> buildPagingData(List data, Pageable pageable, Page page) {
        PagingInfo<T> pagingInfo = new PagingInfo<T>();
        pagingInfo.setContents(data);
        pagingInfo.loadFromPageable(pageable);
        pagingInfo.loadFromPage(page);
        return pagingInfo;
    }
}
