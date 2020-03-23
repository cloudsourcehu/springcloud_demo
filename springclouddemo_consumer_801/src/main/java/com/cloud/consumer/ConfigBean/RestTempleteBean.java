package com.cloud.consumer.ConfigBean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempleteBean {
    @Bean
    @LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    /**
     * 负载均衡  算法   默认是轮询
     * @return
     */
    @Bean
    public IRule myRule()
    {
        //return new RoundRobinRule();  //轮询
        //return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
        return new RetryRule(); //先按照轮询 如果获取失败则在指定时间内会重试 若还是失败就跳过
    }
}
