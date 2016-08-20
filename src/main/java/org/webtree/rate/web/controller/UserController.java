package org.webtree.rate.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.model.User;
import org.webtree.rate.web.service.UserService;

import java.util.List;

import static org.webtree.rate.web.utils.ResponseUtil.wrapResponse;

/**
 * @author Max
 *         Created on 7/16/2016.
 */
@RestController
@RequestMapping("/rest/user")
public class UserController {
    private UserService userService;

    @RequestMapping("/info")
    public ApiResponse<User> getInfo(@RequestParam Long userId) {
        return wrapResponse(userService.findUserById(userId));
    }

    @RequestMapping("/rate-list")
    public ApiResponse<List<User>> getRateList() {
        return wrapResponse(userService.getUserRankTop());
    }

    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public ApiResponse register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setDisplayName(username);
        return wrapResponse(userService.createUser(user));
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}