package org.webtree.rate.web.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Max
 *         Created on 3/13/2016.
 */
@SpringBootApplication
//@EnableWebMvc
@ComponentScan({
    "org.webtree.rate.web.controller",
    "org.webtree.rate.web.service",
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new Object[]{
                Application.class,
                WebMvcConfig.class,
                Neo4jConfig.class
        }, args);
    }
}
