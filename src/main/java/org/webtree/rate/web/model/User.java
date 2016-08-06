package org.webtree.rate.web.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * @author Max
 *         Created on 7/25/2016.
 */
@Data
@NodeEntity
public class User {
    @GraphId
    private Long id;
    private String login;
    private String password;
    private String displayName;

    @Relationship(type = "CREATION")
    private List<Item> items;

    private Long rate = 0L;


}
