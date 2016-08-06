package org.webtree.rate.web.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import org.webtree.rate.web.model.User;

import java.util.List;

/**
 * @author Max
 *         Created on 8/4/2016.
 */
public interface UserRepository extends GraphRepository<User> {
    @Query("MATCH (u:User) return u ORDER BY u:rank LIMIT 100")
    List<User> getUserRankTop();
}
