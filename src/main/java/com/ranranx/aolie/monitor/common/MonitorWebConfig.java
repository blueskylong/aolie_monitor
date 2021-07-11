package com.ranranx.aolie.monitor.common;

import com.ranranx.aolie.core.tools.ApplicationService;
import com.ranranx.aolie.monitor.interceptor.WebInvokerInterceptor;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xxl
 * @version V0.0.1
 * @date 2020/9/1 16:14
 **/
@Configuration
public class MonitorWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebInvokerInterceptor interceptor = new WebInvokerInterceptor();
        AutowireCapableBeanFactory factory = ApplicationService.getApplicationContext().getAutowireCapableBeanFactory();
        factory.autowireBean(interceptor);
        registry.addInterceptor(interceptor);
    }
}

