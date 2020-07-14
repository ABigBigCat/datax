package com.wugui.datax.admin.service.impl;

import com.wugui.datax.admin.datamapper.SystemTaskDOMapper;
import com.wugui.datax.admin.dataobject.SystemTaskDO;
import com.wugui.datax.admin.service.SystemTaskService;
import com.wugui.datax.admin.service.model.SystemTaskModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by jiahui on 2020-07-10 16:27
 */
@Service
public class SystemTaskServiceImpl implements SystemTaskService {

    @Autowired
    private SystemTaskDOMapper systemTaskDOMapper;

    @Override
    public SystemTaskModel addSystemTask(SystemTaskModel systemTaskModel) {
        SystemTaskDO systemTaskDO = this.convertSystemTaskDOFromSystemTaskModel(systemTaskModel);

        systemTaskDOMapper.insertSelective(systemTaskDO);

        return systemTaskModel;
    }

    @Override
    public Boolean deleteTask(Integer id) {
        if (systemTaskDOMapper.deleteByPrimaryKey(id) == 1){
            return true;
        }
        return false;
    }

    private SystemTaskDO convertSystemTaskDOFromSystemTaskModel(SystemTaskModel systemTaskModel){
        if (systemTaskModel == null){
            return null;
        }

        SystemTaskDO systemTaskDO = new SystemTaskDO();
        BeanUtils.copyProperties(systemTaskModel,systemTaskDO);
        systemTaskDO.setCreateTime(new Date());
        systemTaskDO.setStatus(0);
        systemTaskDO.setUpdateTime(new Date());
        return  systemTaskDO;

    }
}
