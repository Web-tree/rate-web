package org.webtree.rate.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.webtree.rate.web.model.ApiResponse;

import static org.webtree.rate.web.utils.ResponseUtils.wrapResponse;

/**
 * @author Max
 *         Created on 7/16/2016.
 */
@RestController
@RequestMapping("/rest/person/creator")
public class CreatorController {
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public void addProject() {

    }

    @RequestMapping("/getRating")
    public ApiResponse<Integer> getRating() {
        return wrapResponse(0);
    }
}
