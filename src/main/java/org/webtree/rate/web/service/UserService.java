package org.webtree.rate.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.webtree.rate.web.model.User;
import org.webtree.rate.web.repository.UserRepository;

import java.util.List;

/**
 * @author Max
 *         Created on 8/4/2016.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    public List<User> getUserRankTop() {
        return userRepository.getUserRankTop();
    }
}
