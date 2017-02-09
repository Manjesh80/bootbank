package com.shivbank;

import com.shivbank.formatters.BookFormatter;
import com.shivbank.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.concurrent.TimeUnit;

/**
 * Created by aadhya on 2/8/2017.
 */

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    /*@Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }*/

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false).setUseTrailingSlashMatch(true);
    }

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void
            customize(ConfigurableEmbeddedServletContainer
                              container) {
                container.setSessionTimeout(5, TimeUnit.SECONDS);
            }
        };
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/internal/**")
                .addResourceLocations("classpath:/")
                .setCachePeriod(300);
    }

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new BookFormatter(bookRepository));
    }
}
