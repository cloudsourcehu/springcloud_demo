package com.cloud.service;

import com.cloud.entitis.DeptEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<FeignClientService> {
    @Override
    public FeignClientService create(Throwable throwable) {
        return new FeignClientService() {
            @Override
            public List<DeptEntity> getList() {
                return null;
            }

            @Override
            public DeptEntity getbyid(int id) {
                DeptEntity deptEntity = new DeptEntity();
                deptEntity.setId(id);
                deptEntity.setName("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
                deptEntity.setDbsource("no this database in MySQL");
                return deptEntity;
            }

        };
    }
}
