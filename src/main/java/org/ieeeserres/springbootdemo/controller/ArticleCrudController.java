package org.ieeeserres.springbootdemo.controller;

import org.ieeeserres.springbootdemo.entity.Article;
import org.ieeeserres.springbootdemo.service.ArticleCrudService;
import org.ieeeserres.springbootdemo.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleCrudController implements CrudController<Article> {

    private final ArticleCrudService articleCrudService;

    public ArticleCrudController(ArticleCrudService articleCrudService) {
        this.articleCrudService = articleCrudService;
    }

    @Override
    public CrudService<Article> getCrudService() {
        return articleCrudService;
    }
}
