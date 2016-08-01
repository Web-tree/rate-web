package org.webtree.rate.web.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

/**
 * @author Max
 *         Created on 7/22/2016.
 */
@Configuration
@EnableConfigurationProperties({ ResourceProperties.class })
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private ResourceProperties resourceProperties = new ResourceProperties();

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Integer cachePeriod = resourceProperties.getCachePeriod();

        registry.addResourceHandler("/app/**")
                .addResourceLocations("classpath:/public/app/")
                .setCachePeriod(cachePeriod);
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/public/css/")
                .setCachePeriod(cachePeriod);
        registry.addResourceHandler("/node_modules/**")
                .addResourceLocations("classpath:/public/node_modules/")
                .setCachePeriod(cachePeriod);
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/public/js/")
                .setCachePeriod(cachePeriod);
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/public/templates/")
                .setCachePeriod(cachePeriod);

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/public/index.html")
                .setCachePeriod(cachePeriod).resourceChain(true)
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath,
                                                   Resource location) throws IOException {
                        return location.exists() && location.isReadable() ? location
                                : null;
                    }
                });
    }
}