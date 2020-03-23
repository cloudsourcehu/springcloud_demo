package com.cloud.provider.controller;

import com.cloud.entitis.DeptEntity;
import com.cloud.provider.service.impl.DeptServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptServiceImpl deptService;


    @RequestMapping(value = "/springcloud/list",method = RequestMethod.GET)
    public List<DeptEntity> list() {
        return deptService.getList();
    }


    @RequestMapping(value = "/springcloud/list/{id}",method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public DeptEntity getByid(@PathVariable("id") int id) {
        DeptEntity deptEntity = deptService.getbyid(id);
        if(null == deptEntity){
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }

        return deptEntity;
    }

    public DeptEntity processHystrix_Get(@PathVariable("id") int id)
    {

        DeptEntity deptEntity = new DeptEntity();
        deptEntity.setId(id);
        deptEntity.setName("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand");
        deptEntity.setDbsource("no this database in MySQL");
        return deptEntity;

    }



}
