package com.Spring_Study.webx.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author wl
 * @ClassNameWebApplicationConfig
 * @Description web应用配置 替代web.xml
 * @Date 2020/3/24
 * @Version 1.0
 */
@Configuration
public class WebApplicationConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        //创建一个上下文配置对象  实现annotationConfigRegistry
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        //将webMVCconfig配置类注解表
        ctx.register(WebMVcConfig.class);
        //设置servletContext
        ctx.setServletContext(servletContext);
        //刷新
        ctx.refresh();
        //映射配置 ctx 的规则对象
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        registration.addMapping("/");
        //设置该映射优先级为1
        registration.setLoadOnStartup(1);

    }
}
