package org.webtree.rate.web.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

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
