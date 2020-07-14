package com.wugui.datax.admin.service;

import com.wugui.datax.admin.service.model.SystemTaskModel;

/**
 * Created by jiahui on 2020-07-10 16:27
 */
public interface SystemTaskService {

    SystemTaskModel addSystemTask(SystemTaskModel systemTaskModel);

    Boolean deleteTask(Integer id);


}
