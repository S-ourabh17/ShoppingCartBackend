package com.build.shopping.security.config;

import com.build.shopping.security.jwt.AuthTokenFilter;
import com.build.shopping.security.jwt.JwtAuthEntryPoint;
import com.build.shopping.security.jwt.JwtUtils;
import com.build.shopping.security.user.ShopUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
