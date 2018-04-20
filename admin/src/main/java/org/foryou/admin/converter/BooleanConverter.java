package org.foryou.admin.converter;

import org.springframework.stereotype.Component;

@Component
public class BooleanConverter {
    public Boolean toBoolean(Integer enable) {
        if (enable == null) {
            return null;
        }
        return enable == 1;
    }

    public Integer toInt(Boolean enable) {
        if (enable == null) {
            return null;
        }
        return enable ? 1 : 0;
    }
}
