package org.foryou.admin.mapper;

import org.springframework.stereotype.Component;

@Component
public class BooleanMapper {
    public boolean toBoolean(int enable) {
        return enable == 1;
    }

    public int toInt(boolean enable) {
        return enable ? 1 : 0;
    }
}
