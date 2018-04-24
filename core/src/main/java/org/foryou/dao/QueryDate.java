package org.foryou.dao;

import org.springframework.format.annotation.DateTimeFormat;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

import java.util.Date;

public class QueryDate {
    @DateTimeFormat(iso = DATE)
    private Date start;
    @DateTimeFormat(iso = DATE)
    private Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
