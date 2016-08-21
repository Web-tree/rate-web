package org.webtree.rate.web.boot;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.webtree.rate.web.init.IndexCreator;

/**
 * @author Max
 *         Created on 8/4/2016.
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "org.webtree.rate.web.repository")
public class Neo4jConfig extends Neo4jConfiguration {
    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory("org.webtree.rate.web.model");
    }

    @Bean
    public Neo4jOperations neo4jTemplate() throws Exception {
        return new Neo4jTemplate(getSession());
    }

    @Bean
    public IndexCreator indexCreator() throws Exception {
        return new IndexCreator(neo4jTemplate());
    }
}
