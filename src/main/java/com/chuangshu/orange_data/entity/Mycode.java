package com.chuangshu.orange_data.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Guo Jiaqi
 * @version 1.0
 * @date 2021/3/23 0:09
 */
public class Mycode implements Serializable {
    private static final long serialVersionUID = -35607135095629700L;
    //当天时间
    private String StrDate;
    //当天数量
    private Integer num;
    //新增数量
    private Integer upNum;

    public Mycode(String strDate, Integer num, Integer upNum) {
        StrDate = strDate;
        this.num = num;
        this.upNum = upNum;
    }

    public String getStrDate() {
        return StrDate;
    }

    public void setStrDate(String strDate) {
        StrDate = strDate;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getUpNum() {
        return upNum;
    }

    public void setUpNum(Integer upNum) {
        this.upNum = upNum;
    }

    public Mycode() {
    }

    @Override
    public String toString() {
        return "Mycode{" +
                "StrDate='" + StrDate + '\'' +
                ", num=" + num +
                ", upNum=" + upNum +
                '}';
    }
}
