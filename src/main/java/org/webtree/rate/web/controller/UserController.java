package org.webtree.rate.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
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
        User user = userService.findUserById(userId);
        if (user == null) {
            return wrapResponse(HttpStatus.NOT_FOUND, "User " + userId + " not found");
        }
        return wrapResponse(user);
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