package org.webtree.rate.web.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.model.User;
import org.webtree.rate.web.service.UserService;
import org.webtree.rate.web.utils.ResponseUtil;

import java.util.List;

import static org.webtree.rate.web.utils.ResponseUtil.createOkResponse;
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
    public ApiResponse register(@RequestParam String login, @RequestParam String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setDisplayName(login);
        return wrapResponse(userService.createUser(user));
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}