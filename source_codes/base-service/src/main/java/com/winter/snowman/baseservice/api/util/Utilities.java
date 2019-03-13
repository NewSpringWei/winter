package com.winter.snowman.baseservice.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Utilities {
    public static String buildDataId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String res = sdf.format(new Date()) + "_" + uuid;
        return res;
    }
}
