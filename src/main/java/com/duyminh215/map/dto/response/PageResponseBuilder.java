package com.duyminh215.map.dto.response;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.duyminh215.map.paging.PagingInfo;

public class PageResponseBuilder {

    public static PagingInfo buildPagingData(List data, Pageable pageable, Page page) {
        PagingInfo pagingInfo = new PagingInfo();
        pagingInfo.setContents(data);
        pagingInfo.loadFromPageable(pageable);
        pagingInfo.loadFromPage(page);
        return pagingInfo;
    }

    public static PagingInfo buildPagingData(Page page, Pageable pageable) {
        PagingInfo pagingInfo = new PagingInfo();
        pagingInfo.setContents(page.getContent());
        pagingInfo.loadFromPageable(pageable);
        pagingInfo.loadFromPage(page);
        return pagingInfo;
    }
}
