package org.webtree.rate.web.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author Max
 *         Created on 8/7/2016.
 */
@Data
@NodeEntity
public class Project {
    @GraphId
    private Long id;
    private String url;
}
