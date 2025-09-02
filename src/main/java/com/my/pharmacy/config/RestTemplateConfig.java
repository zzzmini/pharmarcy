package com.my.pharmacy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
// 스프링시작될 때 @Configuration을 읽어서 Bean으로 등록해 놓는다.
// 사용자는 생성자주입 또는 @Autowired를 사용해서 쓴다.
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
