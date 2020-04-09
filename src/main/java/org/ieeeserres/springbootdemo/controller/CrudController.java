package org.ieeeserres.springbootdemo.controller;

import org.ieeeserres.springbootdemo.service.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface CrudController<ENTITY_TYPE> {

    CrudService<ENTITY_TYPE> getCrudService();

    @PostMapping
    default ResponseEntity<ENTITY_TYPE> create(@RequestBody ENTITY_TYPE entity) {
        ENTITY_TYPE createdEntity = getCrudService().create(entity);

        return ResponseEntity.ok(createdEntity);
    }

    @GetMapping
    default ResponseEntity<List<ENTITY_TYPE>> read() {
        List<ENTITY_TYPE> entities = getCrudService().read();

        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    default ResponseEntity<ENTITY_TYPE> read(@PathVariable String id) {
        Optional<ENTITY_TYPE> read = getCrudService().read(id);

        if(!(read.isPresent())) {
            return ResponseEntity.notFound().build();
        }

        ENTITY_TYPE entity = read.get();

        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    default ResponseEntity<ENTITY_TYPE> update(@PathVariable String id, @RequestBody ENTITY_TYPE entity) {
        ENTITY_TYPE updatedEntity = getCrudService().update(entity, id);

        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    default ResponseEntity<Void> delete(@PathVariable String id) {
        getCrudService().delete(id);

        return ResponseEntity.noContent().build();
    }
}
