package org.webtree.rate.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webtree.rate.web.model.Item;
import org.webtree.rate.web.repository.ItemRepository;

/**
 * @author Max
 *         Created on 8/12/2016.
 */
@Service
public class ItemService extends GraphService<Item, ItemRepository> {
    @Autowired
    public ItemService(ItemRepository repository) {
        super(repository);
    }

    public Item getById(Long itemId) {
        return repository.findOne(itemId);
    }
}
