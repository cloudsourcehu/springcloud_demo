package com.cloud.provider.service;

import com.cloud.entitis.DeptEntity;

import java.util.List;

public interface DeptServices {
    List<DeptEntity> getList();
    DeptEntity getbyid(int  id);

}
