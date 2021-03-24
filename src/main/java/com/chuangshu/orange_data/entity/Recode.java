package com.chuangshu.orange_data.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Recode)实体类
 *
 * @author makejava
 * @since 2021-03-22 21:17:24
 */
public class Recode implements Serializable {
    private static final long serialVersionUID = -35607135095629700L;
    
    private Integer idrecode;
    
    private Integer num;
    
    private Date mytime;
    
    private Integer port;


    public Integer getIdrecode() {
        return idrecode;
    }

    public void setIdrecode(Integer idrecode) {
        this.idrecode = idrecode;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getMytime() {
        return mytime;
    }

    public void setMytime(Date mytime) {
        this.mytime = mytime;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}