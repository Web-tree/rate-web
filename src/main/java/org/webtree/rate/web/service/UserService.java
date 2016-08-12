package org.webtree.rate.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;
import org.webtree.rate.web.model.User;
import org.webtree.rate.web.repository.UserRepository;

import java.util.List;

/**
 * @author Max
 *         Created on 8/4/2016.
 */
@Service
public class UserService extends GraphService<User, UserRepository> {
    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User findUserById(Long id) {
        return repository.findOne(id);
    }

    public List<User> getUserRankTop() {
        return repository.getUserRankTop();
    }
}
