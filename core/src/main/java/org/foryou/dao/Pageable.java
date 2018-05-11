package org.foryou.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 分页limit信息
 */
public class Pageable {
    private int page;
    private int size;
    @JsonIgnore
    private int limitStart;

    public Pageable() {
        this.size = (size == 0) ? 10 : size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLimitStart() {
        return page * getSize();
    }
}
