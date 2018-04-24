package org.foryou.dao;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

    private Pageable pageable;
    private int total;
    private List<T> list;

    public Page() {
    }

    public Page(Pageable pageable, int total, List<T> list) {
        this.pageable = pageable;
        this.total = total;
        this.list = list;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
