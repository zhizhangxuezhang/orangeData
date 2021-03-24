package com.chuangshu.orange_data.service;

import com.chuangshu.orange_data.entity.Mycode;
import com.chuangshu.orange_data.entity.Recode;
import java.util.List;

/**
 * (Recode)表服务接口
 *
 * @author makejava
 * @since 2021-03-22 21:17:25
 */
public interface RecodeService {

    /**
     *查询
     *
     * @return 对象列表
     */
    List<Mycode> queryByMyTime(Integer port);
    //判断端口号是否存在
    boolean queryByPort(Integer port);


}