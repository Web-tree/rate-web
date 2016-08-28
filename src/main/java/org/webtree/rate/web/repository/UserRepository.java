package org.webtree.rate.web.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.webtree.rate.web.model.User;

import java.util.List;

/**
 * @author Max
 *         Created on 8/4/2016.
 */
public interface UserRepository extends GraphRepository<User> {
    @Query("MATCH (u:User) RETURN u ORDER BY u:rank LIMIT 100")
    List<User> getUserRankTop();

    @Query("MATCH (u:User {username: {0}) RETURN u LIMIT 1")
    User getUserByUsername(String username);

    @Query("MATCH (u:User {username: {0}}) RETURN count(u) > 0")
    boolean isUsernameExists(String username);
}
