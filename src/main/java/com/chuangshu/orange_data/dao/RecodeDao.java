package com.chuangshu.orange_data.dao;

import com.chuangshu.orange_data.entity.Recode;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * (Recode)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-22 21:17:25
 */
public interface RecodeDao {

    //查询
    Integer queryByMyTime(@Param("myTimeFirst") Date myTimeFirst , @Param("myTimeLast") Date myTimeLast ,@Param("port") Integer port);

    //根据port查找
    List<Recode> queryByPort(Integer port);
}