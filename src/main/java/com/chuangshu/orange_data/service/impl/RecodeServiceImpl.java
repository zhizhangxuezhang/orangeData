package com.chuangshu.orange_data.service.impl;

import com.chuangshu.orange_data.entity.Mycode;
import com.chuangshu.orange_data.entity.Recode;
import com.chuangshu.orange_data.dao.RecodeDao;
import com.chuangshu.orange_data.service.RecodeService;
import org.apache.ibatis.annotations.One;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (Recode)表服务实现类
 *
 * @author makejava
 * @since 2021-03-22 21:17:25
 */
@Service
public class RecodeServiceImpl implements RecodeService {
    @Resource
    private RecodeDao recodeDao;

    //判断端口号是否存在
    @Override
    public boolean queryByPort(Integer port){
        boolean a = true;
        //先判断当前的端口号在数据库中是否存在
        List<Recode> recodes = recodeDao.queryByPort(port);
        //判断recodes是否为空
        if(recodes.size()==0){
            a = false;
        }
        return a;
    }
    /**
     * 获取最新六天的数据
     *
     *
     * @return 对象列表
     */
    @Override
    public List<Mycode> queryByMyTime(Integer port){
        //获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        //将当前时间转换为date格式
        Date nowDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        //创建list存储6天的date
        List<Date> list = new ArrayList<>();
        //存储第一天
        list.add(nowDay);
        //循环存储二到七天
        for (int a =1;a<7;a++){
            //将当前时间推迟一天
            localDateTime= localDateTime.minus(1, ChronoUnit.DAYS);
            //将时间转换为date格式并存到list中
            list.add(a,Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
        }
        //输出7天的时间
        System.out.println(list.toString());
        //定义一个mylist集合存储数据
        List<Mycode> myList = new ArrayList<Mycode>();
        //记录myList的索引
        int count = 0;
        //遍历查询
        for (int b = 6;b>0;b--){
            //从集合中获取靠 前 的时间点
            Date myTimeFirst = list.get(b);
            //从集合中获取靠 后 的时间点
            Date myTimeLast = list.get(b-1);
            //输出测试
            System.out.println(myTimeFirst);
            System.out.println(myTimeLast);
            //将这个两个时间点形成时间段进行查询，返回数量
            Integer num = recodeDao.queryByMyTime(myTimeFirst,myTimeLast,port);
            //输出数量
            System.out.println(num);
            //定义时间转换格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
            //将时间转换为string类型
            String formatMyTimeLast = simpleDateFormat.format(myTimeLast);
            //创建实体类
            Mycode mycode = new Mycode();
            //存储string类型的时间
            mycode.setStrDate(formatMyTimeLast);
            //存储数量
            mycode.setNum(num);
            //设置增加量
            if(count==0){
                mycode.setUpNum(0);
            }else {
                mycode.setUpNum(num-myList.get(count-1).getNum());
            }
            //输出测试
            System.out.println(mycode.toString());
            //添加到集合中
            myList.add(mycode);
            //索引累加
            count++;
        }
        //返回集合
        return myList;
    }
}