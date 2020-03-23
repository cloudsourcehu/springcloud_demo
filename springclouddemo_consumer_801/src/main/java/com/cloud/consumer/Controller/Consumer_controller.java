package com.cloud.consumer.Controller;

import com.cloud.consumer.ConfigBean.RestTempleteBean;
import com.cloud.entitis.DeptEntity;
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
    RestTemplate restTemplate;
//    final String URL = "http://localhost:8011";
    final String URL = "http://SPRINGCLOUDDEMO";

    @RequestMapping(value = "/consumer/list",method = RequestMethod.GET)
    public List<DeptEntity> list(){
        String requestUrl  = URL+"/springcloud/list";
        LOGGER.error("801Consumer berin .....requestUrl is [{}]", requestUrl);
        return restTemplate.getForObject(requestUrl, List.class);
    }

    @RequestMapping(value = "/consumer/get/{id}",method = RequestMethod.GET)
    public DeptEntity get(@PathVariable("id") int id){
        String requestUrl  = URL+"/springcloud/list/"+ id;
        LOGGER.error("801Consumer berin .....requestUrl is [{}]", requestUrl);
        return restTemplate.getForObject(requestUrl, DeptEntity.class);
    }


    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(URL + "/dept/discovery", Object.class);
    }


}
