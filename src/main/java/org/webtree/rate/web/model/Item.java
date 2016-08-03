package org.webtree.rate.web.model;

import lombok.Data;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author Max
 *         Created on 8/4/2016.
 */
@Data
@NodeEntity
public class Item {
    @GraphId
    private Long id;
}
