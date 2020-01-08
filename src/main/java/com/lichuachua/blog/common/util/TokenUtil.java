package com.lichuachua.blog.common.util;

import java.util.Random;
import java.util.UUID;

public class TokenUtil {
    final static int RAND_UPPER = 0;
    final static int RAND_LOWER = 1;
    final static int RAND_RANGE = 2;
    final static String TOKEN_PREFIX = "WMK";

    private static Random random = new Random();

    public static String genToken() {
        String lowerCaseUUID = UUID.randomUUID().toString().replace("-", "").toLowerCase();

        return TOKEN_PREFIX + randomLowerUpperCase(lowerCaseUUID);
    }

    private static String randomLowerUpperCase(String uuid) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < uuid.length(); i++) {
            int rand = random.nextInt(RAND_RANGE);
            if (rand == RAND_UPPER) {
                stringBuilder.append(String.valueOf(uuid.charAt(i)).toUpperCase());
            } else if (rand == RAND_LOWER) {
                stringBuilder.append(String.valueOf(uuid.charAt(i)).toLowerCase());
            }
        }
        return stringBuilder.toString();
    }



}
