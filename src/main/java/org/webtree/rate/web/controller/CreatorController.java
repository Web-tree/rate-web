package org.webtree.rate.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Max
 *         Created on 7/16/2016.
 */
@Controller
@RequestMapping("/rest/person/creator")
public class CreatorController {
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public void addProject() {

    }

    @RequestMapping("/getRating")
    public int getRating() {
        return 0;
    }
}
