package org.webtree.rate.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Max
 *         Created on 7/16/2016.
 */
@RestController
@RequestMapping("/rest/rank")
public class RankController {
    @RequestMapping("/getItemsTop")
    public ArrayList getItemTop() {
        return new ArrayList();
    }

    @RequestMapping("/getPeopleTop")
    public ArrayList getPeopleTop() {
        return new ArrayList();
    }

    @RequestMapping("/getServicesTop")
    public ArrayList getServicesTop() {
        return new ArrayList();
    }
}
