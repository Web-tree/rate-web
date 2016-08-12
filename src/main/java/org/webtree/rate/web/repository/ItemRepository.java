package org.webtree.rate.web.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.webtree.rate.web.model.Item;

/**
 * @author Max
 *         Created on 8/12/2016.
 */
public interface ItemRepository extends GraphRepository<Item> {
}
