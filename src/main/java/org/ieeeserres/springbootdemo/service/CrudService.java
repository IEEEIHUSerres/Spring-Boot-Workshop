package org.ieeeserres.springbootdemo.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<ENTITY_TYPE> {

    ENTITY_TYPE create(ENTITY_TYPE entity);

    Optional<ENTITY_TYPE> read(String id);

    List<ENTITY_TYPE> read();

    ENTITY_TYPE update(ENTITY_TYPE entity, String id);

    void delete(String id);
}
