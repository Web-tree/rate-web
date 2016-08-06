package org.webtree.rate.web.boot;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

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

//    @Bean
//    GraphDatabaseService graphDatabaseService() {
//        return new GraphDatabaseFactory().newEmbeddedDatabase("rate-web.db");
////        return new Graph
//    }
}
