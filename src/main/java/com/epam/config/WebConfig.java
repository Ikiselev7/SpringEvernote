package com.epam.config;

import com.epam.controllers.MarkController;
import com.epam.controllers.controllerMap.MarkTransformer;
import com.epam.dao.impl.MarkDaoImpl;
import com.epam.dao.jparepositories.MarkJpaRepository;
import com.epam.dao.mappers.MarkMapper;
import com.epam.services.impl.MarkServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {MarkDaoImpl.class,
        MarkJpaRepository.class,
        MarkServiceImpl.class,
        MarkMapper.class,
        MarkTransformer.class,
        MarkController.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
