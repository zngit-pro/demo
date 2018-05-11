package org.foryou.dao;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.format.annotation.DateTimeFormat;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class QueryDate {
    @NotNull
    @DateTimeFormat(iso = DATE)
    private Date start;

    @NotNull
    @DateTimeFormat(iso = DATE)
    private Date end;

    private String cacheKey;

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

    public String getCacheKey() {
        cacheKey = "";
        cacheKey = start != null ? DateFormatUtils.format(start, "yyyyMMdd") : null;
        cacheKey += "-";
        cacheKey += end != null ? DateFormatUtils.format(end, "yyyyMMdd") : null;
        cacheKey += "-";
        return cacheKey;
    }
}
