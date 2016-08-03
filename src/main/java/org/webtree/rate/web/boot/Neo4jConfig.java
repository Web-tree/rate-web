package org.webtree.rate.web.boot;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * @author Max
 *         Created on 8/4/2016.
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "org.webtree.rate.web.repository")
public class Neo4jConfig extends Neo4jConfiguration {
    public Neo4jConfig() {
        setBasePackage("org.webtree.rate.web.model");
    }

    @Bean
    GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("rate-web.db");
    }
}
