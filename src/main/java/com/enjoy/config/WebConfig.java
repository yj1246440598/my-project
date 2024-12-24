package com.enjoy.config;

import com.enjoy.interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private Image image;

    @PostConstruct
    public void init() {
        System.out.println("WebConfig init");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login", "/css/**", "/js/**", "/images/**", "/course/**")
                .excludePathPatterns("/monitorfile/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/images/uploadss").setViewName("upload");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //测试http://localhost:9999/monitorfile/1.png
        String property = System.getProperty("os.name");
        String path = "file:" + image.getPath();
        if (property.equalsIgnoreCase("WINDOWS")) {
            //windows下要有盘符
            String property1 = System.getProperty("user.dir");
            if (!StringUtils.isEmpty(property1)) {
                path = "file:" + property1.split(File.separator)[0] + image.getPath();
            }
        }
        registry.addResourceHandler("/monitorfile/**").addResourceLocations(path);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    @Bean
//    public InternalResourceViewResolver resourceViewResolver(){
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        //请求视图文件的前缀地址
//        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
//        //请求视图文件的后缀
//        internalResourceViewResolver.setSuffix(".jsp");
//        return internalResourceViewResolver;
//    }
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.viewResolver(resourceViewResolver());
////        registry.jsp("/WEB-INF/jsp/","jsp");
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }
}
