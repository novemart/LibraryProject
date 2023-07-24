package com.example.LibrarySpringBoot.sec;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/book").setViewName("myFirstView");
        registry.addViewController("/").setViewName("myFirstView");
        registry.addViewController("/mems").setViewName("members");
        registry.addViewController("/login").setViewName("login");
    }
}
