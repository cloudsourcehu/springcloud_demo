package com.cloud.provider.controller;

import com.cloud.entitis.DeptEntity;
import com.cloud.provider.service.impl.DeptServiceImpl;
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

//    @Autowired
//    DiscoveryClient client;

    @RequestMapping(value = "/springcloud/list",method = RequestMethod.GET)
    public List<DeptEntity> list() {

        return deptService.getList();
    }
    @RequestMapping(value = "/springcloud/list/{id}",method = RequestMethod.GET)
    public DeptEntity getByid(@PathVariable("id") int id) {
        DeptEntity deptEntity = deptService.getbyid(id);
        return deptEntity;
    }


//    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
//    public Object discovery()
//    {
//        List<String> list = client.getServices();
//        System.out.println("**********" + list);
//
//        List<ServiceInstance> srvList = client.getInstances("SPRINGCLOUDDEMO");
//        for (ServiceInstance element : srvList) {
//            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
//                    + element.getUri());
//        }
//        return this.client;
//    }


}
