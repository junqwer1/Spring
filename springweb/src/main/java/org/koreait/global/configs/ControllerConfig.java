package org.koreait.global.configs;

import org.koreait.member.controllers.MemberController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.koreait")
public class ControllerConfig {

    /*@Bean
    public MemberController memberController() {
        return new MemberController();
    }*/
}