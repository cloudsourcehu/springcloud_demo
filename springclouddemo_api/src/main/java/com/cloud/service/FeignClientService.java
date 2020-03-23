package com.cloud.service;

import com.cloud.entitis.DeptEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 *  @Description: 修改-api工程，根据已经有的FeignClientService接口
 *
 * 新建
 *
 * 一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 */
//@FeignClient(value = "SPRINGCLOUDDEMO")
@FeignClient(value = "SPRINGCLOUDDEMO",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface FeignClientService {

    @RequestMapping(value = "/springcloud/list",method = RequestMethod.GET)
    List<DeptEntity> getList();

    @RequestMapping(value = "/springcloud/list/{id}",method = RequestMethod.GET)
    DeptEntity getbyid(@PathVariable("id") int id );
}
