package org.icmic.icmicweb.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class DateUtil {
    public static String withoutT(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
