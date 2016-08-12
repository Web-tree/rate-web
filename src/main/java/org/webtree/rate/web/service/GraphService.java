package org.webtree.rate.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.webtree.rate.web.model.GraphModel;
import org.webtree.rate.web.repository.ItemRepository;

/**
 * @author Max
 *         Created on 8/12/2016.
 */
abstract class GraphService<T extends GraphModel, R extends GraphRepository<T>> {
    final R repository;

    GraphService(R repository) {
        this.repository = repository;
    }

    public T create(T model) {
        if (model.getId() != null) {
            throw new IllegalArgumentException("Item already has id: " + model.getId() + ". Should call update method or logic error.");
        }
        return repository.save(model);
    }

    public T update(T model) {
        if (model.getId() == null) {
            throw new IllegalArgumentException("Item hasn't id. Should call create method or logic error.");
        }
        return repository.save(model);
    }
}
