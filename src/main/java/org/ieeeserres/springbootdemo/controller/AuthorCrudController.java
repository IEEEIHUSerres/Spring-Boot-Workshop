package org.ieeeserres.springbootdemo.controller;

import org.ieeeserres.springbootdemo.entity.Author;
import org.ieeeserres.springbootdemo.service.AuthorCrudService;
import org.ieeeserres.springbootdemo.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorCrudController implements CrudController<Author> {

    private final AuthorCrudService authorCrudService;

    public AuthorCrudController(AuthorCrudService authorCrudService) {
        this.authorCrudService = authorCrudService;
    }

    @Override
    public CrudService<Author> getCrudService() {
        return authorCrudService;
    }
}
