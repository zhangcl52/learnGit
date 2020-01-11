package xin.smoon.springwater.wechatapi.framework.configuration.web;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class DateConverter implements Converter<String, Date> {

    private static final List<String> FORMATS = Lists.newArrayListWithCapacity(4);

    static {
        FORMATS.add("yyyy-MM");
        FORMATS.add("yyyy-MM-dd");
        FORMATS.add("yyyy-MM-dd hh:mm");
        FORMATS.add("yyyy-MM-dd hh:mm:ss");
    }

    @Override
    public Date convert(String source) {
        String value = source.trim();
        if (StringUtils.isBlank(value)) {
            return null;
        }
        if (source.matches("^\\d{4}-\\d{1,2}$")) {
            return parseDate(source, FORMATS.get(0));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return parseDate(source, FORMATS.get(1));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            return parseDate(source, FORMATS.get(2));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return parseDate(source, FORMATS.get(3));
        } else {
            throw new IllegalArgumentException("Invalid  value '" + source + "'");
        }
    }

    /**
     * 格式化日期
     *
     * @param dateStr String 字符型日期
     * @param format  String 格式
     * @return Date 日期
     */
    private Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {
            log.error("DateConverter格式化日期:{}错误", e);
        }
        return date;
    }

}
