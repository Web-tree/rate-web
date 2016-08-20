package org.webtree.rate.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.utils.TokenUtils;

import static org.webtree.rate.web.utils.ResponseUtil.wrapResponse;

/**
 * @author Max
 *         Created on 8/18/2016.
 */
@RestController
@RequestMapping("/auth")
public class SecurityController {
    private final TokenUtils tokenUtils;

    @Autowired
    public SecurityController(TokenUtils tokenUtils) {
        this.tokenUtils = tokenUtils;
    }

    @RequestMapping("/getToken")
    public ApiResponse<String> getToken(@RequestParam String username, @RequestParam String password) {
        return wrapResponse(tokenUtils.generateToken(username, password));
    }
}
