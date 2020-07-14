package com.wugui.datax.admin.controller;

import com.wugui.datatx.core.biz.model.ReturnT;
import com.wugui.datax.admin.datamapper.CloudAccountDOMapper;
import com.wugui.datax.admin.dataobject.CloudAccountDO;
import com.wugui.datax.admin.service.CloudAccountService;
import com.wugui.datax.admin.service.model.CloudAccountModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiahui on 2020-07-10 10:23
 */
@RestController
@RequestMapping("/api/cloud")
@Api(tags = "云账号接口")
public class CloudAccountController extends BaseController{

    @Autowired
    private CloudAccountService cloudAccountService;

    @Autowired
    private CloudAccountDOMapper cloudAccountDOMapper;

    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    @ResponseBody
    @ApiOperation("删除云账号")
    public ReturnT delAccount(@RequestParam(name = "id")Integer id){
        Boolean result = cloudAccountService.deleteAccount(id);

        return new ReturnT(result);

    }

    @PostMapping("/add")
    @ApiOperation("添加云账号")
    public ReturnT allCloudAccount(@RequestBody CloudAccountModel cloudAccountModel){

        CloudAccountModel accountModel = cloudAccountService.addCloudAccount(cloudAccountModel);

        return new ReturnT(accountModel);
    }

    @GetMapping("/pageList")
    @ApiOperation("云账号列表")
    public ReturnT<Map<String, Object>> pageList(@RequestParam(required = false, defaultValue = "1") int current,
                                                 @RequestParam(required = false, defaultValue = "10") int size,
                                                 String username) {

        // page list
        List<CloudAccountDO> list = cloudAccountDOMapper.pageList((current - 1) * size, size, username);
        int recordsTotal = cloudAccountDOMapper.pageListCount((current - 1) * size, size, username);

        // package result
        Map<String, Object> maps = new HashMap<>();
        maps.put("recordsTotal", recordsTotal);        // 总记录数
        maps.put("recordsFiltered", recordsTotal);    // 过滤后的总记录数
        maps.put("data", list);                    // 分页列表
        return new ReturnT<>(maps);
    }

    @GetMapping("/list")
    @ApiOperation("云账号列表")
    public ReturnT<List<CloudAccountModel>> list() {

        // page list
        List<CloudAccountModel> list = cloudAccountService.getCloudList();
        return new ReturnT<>(list);
    }




}
