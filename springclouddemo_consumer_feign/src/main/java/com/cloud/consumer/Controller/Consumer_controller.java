package com.cloud.consumer.Controller;

import com.cloud.consumer.ConfigBean.RestTempleteBean;
import com.cloud.entitis.DeptEntity;
import com.cloud.service.FeignClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Consumer_controller {
    final Logger LOGGER = LoggerFactory.getLogger(Consumer_controller.class);
    @Autowired
    FeignClientService service;

    @RequestMapping(value = "/consumer/list",method = RequestMethod.GET)
    public List<DeptEntity> list(){
        LOGGER.error("801Consumer Feign begin list.....");
        return service.getList();
    }

    @RequestMapping(value = "/consumer/get/{id}",method = RequestMethod.GET)
    public DeptEntity get(@PathVariable("id") int id){
        LOGGER.error("801Consumer Feign begin get.....");
        return service.getbyid(id);
    }




}
