package org.webtree.rate.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.model.User;
import org.webtree.rate.web.service.UserService;
import org.webtree.rate.web.utils.TokenUtils;

import static org.webtree.rate.web.utils.ResponseUtils.ok;

/**
 * @author Max
 *         Created on 8/18/2016.
 */
@RestController
@RequestMapping("/security")
public class SecurityController {
    private final TokenUtils tokenUtils;
    private final UserService userService;

    @Autowired
    public SecurityController(TokenUtils tokenUtils, UserService userService) {
        this.tokenUtils = tokenUtils;
        this.userService = userService;
    }

    @RequestMapping("/getToken")
    public ApiResponse<String> getToken(@RequestParam String username, @RequestParam String password) {
        return ok(tokenUtils.generateToken(username, password));
    }

    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public ApiResponse register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setDisplayName(username);
        return ok(userService.createUser(user));
    }
}
