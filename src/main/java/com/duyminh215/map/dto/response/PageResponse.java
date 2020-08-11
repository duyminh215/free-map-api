package com.duyminh215.map.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResponse<T> {

    private T content;
    private PageMetadata pageMetadata;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public PageMetadata getPageMetadata() {
        return pageMetadata;
    }

    public void setPageMetadata(PageMetadata pageMetadata) {
        this.pageMetadata = pageMetadata;
    }

    @Getter
    @Setter
    // @AllArgsConstructor
    public static class PageMetadata {

        private Integer size;
        private Integer number;
        private Integer totalPages;
        private Long totalElements;

        public PageMetadata(Integer size, Integer number, Integer totalPages, Long totalElements) {
            this.size = size;
            this.number = number;
            this.totalPages = totalPages;
            this.totalElements = totalElements;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public Long getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(Long totalElements) {
            this.totalElements = totalElements;
        }
    }

}