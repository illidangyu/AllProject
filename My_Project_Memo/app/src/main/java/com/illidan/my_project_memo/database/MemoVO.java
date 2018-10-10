package com.illidan.my_project_memo.database;

import android.os.SystemClock;

import com.illidan.my_project_memo.util.MemoUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoVO {
    private String memoKey;
    private String memoCat;
    private String memoTitle;
    private String memoInData;
    private String memoYetData;
    private String memoFinishData;
    private String memoText;

    public MemoVO() {
    }

    public MemoVO(String memoKey, String memoCat, String memoTitle, String memoInData, String memoYetData, String memoFinishData, String memoText) {
        this.memoKey = memoKey;
        this.memoCat = memoCat;
        this.memoTitle = memoTitle;
        this.memoInData = memoInData;
        this.memoYetData = memoYetData;
        this.memoFinishData = memoFinishData;
        this.memoText = memoText;
    }

    public MemoVO(String memoText) {
        String curDateTime = MemoUtils.getCurrentDate();
//        현재날짜구하기
//        leval 26 이상 : LocalDataTime 사용
//        시스템의 시간 = UNIX Time
        this.memoText = memoText;
        this.memoTitle = curDateTime + "에 만든 메모";
        this.memoInData = curDateTime;
    }

    public String getMemoKey() {
        return memoKey;
    }

    public void setMemoKey(String memoKey) {
        this.memoKey = memoKey;
    }

    public String getMemoCat() {
        return memoCat;
    }

    public void setMemoCat(String memoCat) {
        this.memoCat = memoCat;
    }

    public String getMemoTitle() {
        return memoTitle;
    }

    public void setMemoTitle(String memoTitle) {
        this.memoTitle = memoTitle;
    }

    public String getMemoInData() {
        return memoInData;
    }

    public void setMemoInData(String memoInData) {
        this.memoInData = memoInData;
    }

    public String getMemoYetData() {
        return memoYetData;
    }

    public void setMemoYetData(String memoYetData) {
        this.memoYetData = memoYetData;
    }

    public String getMemoFinishData() {
        return memoFinishData;
    }

    public void setMemoFinishData(String memoFinishData) {
        this.memoFinishData = memoFinishData;
    }

    public String getMemoText() {
        return memoText;
    }

    public void setMemoText(String memoText) {
        this.memoText = memoText;
    }
}
