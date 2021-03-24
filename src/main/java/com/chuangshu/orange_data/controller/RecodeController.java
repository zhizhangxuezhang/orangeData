package com.chuangshu.orange_data.controller;

import com.chuangshu.orange_data.entity.Mycode;
import com.chuangshu.orange_data.entity.Recode;
import com.chuangshu.orange_data.result.Result;
import com.chuangshu.orange_data.result.ResultUtil;
import com.chuangshu.orange_data.service.RecodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Recode)表控制层
 *
 * @author makejava
 * @since 2021-03-22 21:17:26
 */
@RestController
@RequestMapping("recode")
@Api(tags = {"柑橘木虱数据"})
public class RecodeController {
    /**
     * 服务对象
     */
    @Resource
    private RecodeService recodeService;

    @ApiOperation(value = "查询柑橘木虱数据")
    @GetMapping("selByMyTimeAndPort")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "port", dataType = "int", required = true, value = "端口号"),
    })
    public Result<Object> selByMyTimeAndPort(Integer port){
        //参数不能为空
        if(port==null){
            return ResultUtil.Error("404","参数不能为空",null);
        }
        //数据库中是否有该端口号
        boolean b = recodeService.queryByPort(port);
        if (b == false){
            return ResultUtil.Error("404","查无此端口号",null);
        }

        List<Mycode> mycodes = recodeService.queryByMyTime(port);
        return ResultUtil.Success(mycodes);
    }
}