package org.foryou.dao;

public class Pageable {
    private int page;
    private int size;
    private int limitStart;

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
        return page * size;
    }
}
