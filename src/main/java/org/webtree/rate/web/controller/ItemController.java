package org.webtree.rate.web.controller;

/**
 * @author Max
 *         Created on 8/6/2016.
 */

import com.google.common.collect.Lists;
import com.google.protobuf.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.model.Item;
import org.webtree.rate.web.model.Project;
import org.webtree.rate.web.model.User;
import org.webtree.rate.web.utils.ResponseUtil;

import java.util.List;

import static org.webtree.rate.web.utils.ResponseUtil.wrapResponse;

@RestController
@RequestMapping("/rest/item")
public class ItemController {
    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public ApiResponse<Item> createItem(@RequestBody Item item) {
        item.setId(123L);
        return wrapResponse(item);
    }

    @RequestMapping("/get/{id}")
    public ApiResponse<Item> getItem(@PathVariable("id") Long id) {
        Item item = new Item();
        item.setId(id);
        item.setName("test item");
        return wrapResponse(item);
    }

    @RequestMapping("/getByUser/{id}")
    public ApiResponse<List<Item>> getItemsByCreator(@PathVariable("id") Long id) {
        Item item = new Item();
        item.setName("test item");
        User creator = new User();
        creator.setDisplayName("test user");
        creator.setId(id);
        item.setCreator(creator);
        return wrapResponse(Lists.newArrayList(item));
    }

    @RequestMapping("/getByProject/{id}")
    public ApiResponse<List<Item>> getItemsByProject(@PathVariable("id") Long id) {
        Item item = new Item();
        Project project = new Project();
        project.setId(id);
        project.setUrl("test.url");
        item.setProjects(Lists.newArrayList(project));
        item.setProjects(Lists.newArrayList(project));
        return wrapResponse(Lists.newArrayList(item));
    }
}
