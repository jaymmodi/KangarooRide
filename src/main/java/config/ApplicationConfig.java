package config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * Created by jmmodi on 11/9/2015.
 */

@Configuration
@EnableAsync
@ComponentScan(basePackages = {"controllers"})
public class ApplicationConfig {


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
}