//package com.jenson.board.config;
//
//import org.apache.catalina.servlets.WebdavServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class H2Configuration {
//
//    @Bean
//    public ServletRegistrationBean h2servletRegistration() {
//        String webConsoleUrl = "/console/*";
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebdavServlet());
//        registrationBean.addUrlMappings(webConsoleUrl);
//        return registrationBean;
//    }
//}
