package com.abc.validatordemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@Configuration
public class AppConfiguration {

    @Bean
    @Qualifier("localValidatorFactoryBean")
    public Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}
