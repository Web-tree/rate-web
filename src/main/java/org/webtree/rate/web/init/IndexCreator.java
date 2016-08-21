package org.webtree.rate.web.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

/**
 * @author Max
 *         Created on 8/21/2016.
 */
@Component
public class IndexCreator {
    private final Neo4jOperations neo4jTemplate;

    @Autowired
    public IndexCreator(Neo4jOperations neo4jTemplate) {
        this.neo4jTemplate = neo4jTemplate;
    }

    @PostConstruct
    public void createIndexes() {
        neo4jTemplate.query("CREATE CONSTRAINT ON (user:User) ASSERT user.username IS UNIQUE", Collections.emptyMap());
    }
}
