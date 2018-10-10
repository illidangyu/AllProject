package com.illidan.my_project_memo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoUtils {

    public static String getCurrentDate(){
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String getDate = dateFormat.format(date);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String getTime = format.format(date);
        return getDate + " " + getTime;
    }
}
