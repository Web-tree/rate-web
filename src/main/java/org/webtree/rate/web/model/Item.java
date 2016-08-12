package org.webtree.rate.web.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * @author Max
 *         Created on 8/4/2016.
 */
@Data
@NodeEntity
public class Item implements GraphModel {
    @GraphId
    private Long id;
    private String name;
    @Relationship(type = "CREATION")
    private User creator;

    @Relationship(type = "IN-PROJECT")
    private List<Project> projects;
    private ItemType type;
}