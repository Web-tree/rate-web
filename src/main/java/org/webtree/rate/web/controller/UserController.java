package org.webtree.rate.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.model.User;
import org.webtree.rate.web.service.UserService;

import java.util.List;

import static org.webtree.rate.web.utils.ResponseUtils.createOkResponse;
import static org.webtree.rate.web.utils.ResponseUtils.wrapResponse;

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

    @RequestMapping(value = "/isValidUsername", method = RequestMethod.POST)
    public ApiResponse checkUserName(@RequestParam String username) {
        if (StringUtils.isEmpty(username)) {
            return wrapResponse(HttpStatus.BAD_REQUEST, "Username is empty");
        }
        if (userService.isUsernameExists(username)) {
            return wrapResponse(HttpStatus.BAD_REQUEST, "Username already exists");
        }
        return createOkResponse();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}