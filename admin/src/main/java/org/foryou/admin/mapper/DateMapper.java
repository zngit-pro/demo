package org.foryou.admin.mapper;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Date;

@Component
public class DateMapper {
    private final String pattern = "yyyy-MM-dd HH:mm:ss";

    public Date toDate(String dateStr) throws ParseException {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        return DateUtils.parseDate(dateStr, pattern);
    }

    public String toString(Date date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        return DateFormatUtils.format(date, pattern);
    }
}
