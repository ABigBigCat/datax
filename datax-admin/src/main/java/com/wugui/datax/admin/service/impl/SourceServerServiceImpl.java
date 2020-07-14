package com.wugui.datax.admin.service.impl;

import com.wugui.datax.admin.datamapper.SourceServerDOMapper;
import com.wugui.datax.admin.dataobject.SourceServerDO;
import com.wugui.datax.admin.service.SourceServerService;
import com.wugui.datax.admin.service.model.SourceServerModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiahui on 2020-07-10 15:52
 */
@Service
public class SourceServerServiceImpl implements SourceServerService {

    @Autowired
    private SourceServerDOMapper sourceServerDOMapper;

    @Override
    public SourceServerModel addSourceServer(SourceServerModel sourceServerModel) {

        SourceServerDO sourceServerDO = this.convertSourceServerDOFromSourceServerModel(sourceServerModel);

        sourceServerDOMapper.insertSelective(sourceServerDO);

        return sourceServerModel;
    }

    @Override
    public List<SourceServerModel> getSourceList() {

        //获取所有源服务器数据
        List<SourceServerDO> sourceServerDOS = sourceServerDOMapper.listSource();
        //遍历输出model
        List<SourceServerModel> sourceServerModels = sourceServerDOS.stream().map(sourceServerDO -> {
            SourceServerModel sourceServerModel = this.convertSourceServerModelFromSourceServerDO(sourceServerDO);
            return sourceServerModel;
        }).collect(Collectors.toList());

        return sourceServerModels;
    }

    @Override
    public Boolean deleteSource(Integer id) {
        if (sourceServerDOMapper.deleteByPrimaryKey(id) == 1){
            return true;
        }
        return false;
    }

    private SourceServerDO convertSourceServerDOFromSourceServerModel(SourceServerModel sourceServerModel){
        if (sourceServerModel == null){
            return null;
        }

        SourceServerDO sourceServerDO = new SourceServerDO();
        BeanUtils.copyProperties(sourceServerModel,sourceServerDO);
        sourceServerDO.setCreateDate(new Date());
        sourceServerDO.setStatus(0);
        sourceServerDO.setUpdateDate(new Date());
        return sourceServerDO;

    }

    private SourceServerModel convertSourceServerModelFromSourceServerDO(SourceServerDO sourceServerDO){
        if (sourceServerDO == null){
            return null;
        }

        SourceServerModel sourceServerModel = new SourceServerModel();
        BeanUtils.copyProperties(sourceServerDO,sourceServerModel);
        return sourceServerModel;
    }
}
