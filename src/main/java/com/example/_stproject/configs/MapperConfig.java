package com.example._stproject.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class MapperConfig {
    @Bean
    public ModelMapper getmodelMapper(){
        return new ModelMapper();
    }
}
