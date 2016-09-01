package org.webtree.rate.web.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Max
 *         Created on 3/13/2016.
 */
@SpringBootApplication
@ComponentScan({
        "org.webtree.rate.web.advice",
        "org.webtree.rate.web.controller",
        "org.webtree.rate.web.handler",
        "org.webtree.rate.web.security",
        "org.webtree.rate.web.service",
        "org.webtree.rate.web.utils",
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new Object[]{
                Application.class,
                WebMvcConfig.class,
                Neo4jConfig.class,
                WebSecurityConfiguration.class
        }, args);
    }
}
