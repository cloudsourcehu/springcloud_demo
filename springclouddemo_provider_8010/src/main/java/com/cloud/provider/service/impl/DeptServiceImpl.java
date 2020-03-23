package com.cloud.provider.service.impl;

import com.cloud.entitis.DeptEntity;
import com.cloud.provider.service.DeptServices;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptServices {
    static List<DeptEntity> list = new LinkedList<>();

    @Override
    public List<DeptEntity> getList() {

        for (int i = 0; i < 5; i++) {
            DeptEntity deptEntity = new DeptEntity();
            deptEntity.setId(i);
            deptEntity.setName("joke"+i);
            deptEntity.setDbsource("8010");
            list.add(deptEntity);
        }
        return list;
    }
    @Override
    public DeptEntity getbyid(int id) {
        for(DeptEntity deptEntity : list){
            if(id == deptEntity.getId()){
                return deptEntity;
            }
        }
        return null;
    }
}
