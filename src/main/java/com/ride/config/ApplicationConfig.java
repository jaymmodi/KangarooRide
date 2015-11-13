package com.ride.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by jmmodi on 11/9/2015.
 */

@Configuration
@EnableAsync
@EnableWebMvc
@ComponentScan(basePackages = {"com.ride"})
public class ApplicationConfig extends WebMvcConfigurerAdapter {


    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);

        return viewResolver;
    }


    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine bean = new SpringTemplateEngine();
        bean.setTemplateResolver(templateResolver());
        bean.addDialect(new LayoutDialect());
        return bean;
    }

    @Bean
    public TemplateResolver templateResolver() {
        ServletContextTemplateResolver bean = new ServletContextTemplateResolver();
        bean.setCacheable(false);
        bean.setTemplateMode("HTML5");
        bean.setPrefix("/WEB-INF/templates/");
        bean.setSuffix(".html");
        return bean;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/TEST");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");

        return dataSource;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("modi.jay6@gmail.com");
        javaMailSender.setPassword("Dravid@01081960");
        javaMailSender.setJavaMailProperties(getProperties());
        return javaMailSender;
    }

    private Properties getProperties() {
        Properties properties = System.getProperties();
        properties.setProperty("mail.transport.prtotocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        return properties;
    }
}