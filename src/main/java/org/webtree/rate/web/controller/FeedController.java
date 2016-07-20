package org.webtree.rate.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.webtree.rate.web.model.FeedMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Max
 *         Created on 3/13/2016.
 */
@Controller
@RequestMapping("/rest/feed")
public class FeedController {
    @RequestMapping("/messages")
    public List<FeedMessage> getFeed() {
        return new ArrayList<FeedMessage>() {{
            add(new FeedMessage() {
                @Override
                public Date getDate() {
                    return new Date();
                }

                @Override
                public String getMessage() {
                    return "Hi all!!!";
                }
            });
        }};
    }
}
