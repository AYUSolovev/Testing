package servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean servletRegisterNormalUser(){
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new ServletRegisterNormalUser(),"/user/register");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public ServletRegistrationBean servletLoginUser(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new ServletLoginUser(),"/user/login");
        bean.setLoadOnStartup(1);
        return bean;
    }
/*
    @Bean
    public ServletRegistrationBean servletQuestion(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new ServletQuestion(), "/question");
        bean.setLoadOnStartup(1);
        return bean;
    }
*/
    @Bean
    public FilterRegistrationBean securityServletFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new SecurityServletFilter());
        bean.addUrlPatterns("/user/*");
        return bean;
    }

}
