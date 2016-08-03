package org.webtree.rate.web.model;

import lombok.Data;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

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

    @RelatedTo(type = "CREATION")
    private List<Item> items;

    private Long rate;


}
