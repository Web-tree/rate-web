package org.webtree.rate.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.webtree.rate.web.model.User;
import org.webtree.rate.web.repository.UserRepository;

import java.util.List;

/**
 * @author Max
 *         Created on 8/4/2016.
 */
@Service
public class UserService extends GraphService<User, UserRepository> implements UserDetailsService {
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

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO: implement it
        User user = new User();
        user.setId(10L);
        user.setUsername(username);
        user.setPassword("test");
        return user;
    }
}
