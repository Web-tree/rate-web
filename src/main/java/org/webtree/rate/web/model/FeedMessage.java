package org.webtree.rate.web.model;

import java.util.Date;

/**
 * @author Max
 *         Created on 3/13/2016.
 */
public interface FeedMessage<T> {
    Date getDate();
    T getMessage();
}
