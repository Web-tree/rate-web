package org.webtree.rate.web.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import org.webtree.rate.web.model.User;

/**
 * @author Max
 *         Created on 8/4/2016.
 */
public interface UserRepository extends GraphRepository<User> {

}
