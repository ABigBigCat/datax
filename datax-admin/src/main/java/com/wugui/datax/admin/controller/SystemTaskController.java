package com.wugui.datax.admin.controller;

import com.wugui.datatx.core.biz.model.ReturnT;
import com.wugui.datax.admin.datamapper.SystemTaskDOMapper;
import com.wugui.datax.admin.dataobject.SystemTaskDO;
import com.wugui.datax.admin.service.SystemTaskService;
import com.wugui.datax.admin.service.model.SystemTaskModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiahui on 2020-07-13 09:07
 */
@RestController
@RequestMapping("/api/task")
@Api(tags = "系统盘任务接口")
public class SystemTaskController {

    @Autowired
    private SystemTaskService systemTaskService;

    @Autowired
    private SystemTaskDOMapper systemTaskDOMapper;

    @PostMapping("/add")
    @ApiOperation("添加系统盘任务")
    public ReturnT addSystemTask(@RequestBody SystemTaskModel systemTaskModel){

        SystemTaskModel taskModel = systemTaskService.addSystemTask(systemTaskModel);

        return new ReturnT(taskModel);

    }

    @GetMapping("/pageList")
    @ApiOperation("系统盘任务列表")
    public ReturnT<Map<String, Object>> pageList(@RequestParam(required = false, defaultValue = "1") int current,
                                                 @RequestParam(required = false, defaultValue = "10") int size,
                                                 String username) {

        // page list
        List<SystemTaskDO> list = systemTaskDOMapper.pageList((current - 1) * size, size, username);
        int recordsTotal = systemTaskDOMapper.pageListCount((current - 1) * size, size, username);

        // package result
        Map<String, Object> maps = new HashMap<>();
        maps.put("recordsTotal", recordsTotal);        // 总记录数
        maps.put("recordsFiltered", recordsTotal);    // 过滤后的总记录数
        maps.put("data", list);                    // 分页列表
        return new ReturnT<>(maps);
    }

    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    @ResponseBody
    @ApiOperation("删除系统盘任务")
    public ReturnT delTask(@RequestParam(name = "id")Integer id){
        Boolean result = systemTaskService.deleteTask(id);

        return new ReturnT(result);

    }


}
