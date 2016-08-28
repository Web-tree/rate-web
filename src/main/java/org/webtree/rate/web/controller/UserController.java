package org.webtree.rate.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/{userId}")
    public ApiResponse<User> getInfo(@PathVariable("userId") Long userId) {
        return wrapResponse(userService.findUserById(userId));
    }

    @RequestMapping("/rate-list")
    public ApiResponse<List<User>> getRateList() {
        return wrapResponse(userService.getUserRankTop());
    }

    @RequestMapping("/currentUser")
    @Secured("ROLE_USER")
    public ApiResponse<User> getCurrentUser() {
        return wrapResponse((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}