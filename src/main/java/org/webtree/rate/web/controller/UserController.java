package org.webtree.rate.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.model.User;
import org.webtree.rate.web.service.UserService;

import java.util.List;

import static org.webtree.rate.web.model.ApiResponseType.BAD_REQUEST;
import static org.webtree.rate.web.model.ApiResponseType.NOT_FOUND;
import static org.webtree.rate.web.utils.ResponseUtils.ok;
import static org.webtree.rate.web.utils.ResponseUtils.wrap;

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
        User user = userService.findUserById(userId);
        if (user == null) {
            return wrap(NOT_FOUND, "User " + userId + " not found");
        }
        return ok(user);
    }

    @RequestMapping("/rate-list")
    public ApiResponse<List<User>> getRateList() {
        return ok(userService.getUserRankTop());
    }

    @RequestMapping("/currentUser")
    @Secured("ROLE_USER")
    public ApiResponse<User> getCurrentUser() {
        return ok((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    @RequestMapping(value = "/isValidUsername", method = RequestMethod.POST)
    public ApiResponse checkUserName(@RequestParam String username) {
        if (StringUtils.isEmpty(username)) {
            return wrap(BAD_REQUEST, "Username is empty");
        }
        if (userService.isUsernameExists(username)) {
            return wrap(BAD_REQUEST, "Username already exists");
        }
        return ok();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}