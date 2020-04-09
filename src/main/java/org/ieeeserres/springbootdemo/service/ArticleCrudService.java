package org.ieeeserres.springbootdemo.service;

import org.ieeeserres.springbootdemo.entity.Article;
import org.ieeeserres.springbootdemo.entity.Author;
import org.ieeeserres.springbootdemo.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleCrudService implements CrudService<Article> {

    private final ArticleRepository articleRepository;
    private final AuthorCrudService authorCrudService;

    public ArticleCrudService(ArticleRepository articleRepository, AuthorCrudService authorCrudService) {
        this.articleRepository = articleRepository;
        this.authorCrudService = authorCrudService;
    }

    @Override
    public Article create(Article entity) {
        Optional<Author> read = authorCrudService.read(entity.getAuthor().getId());

        if(!(read.isPresent())) {
            throw new EntityNotFoundException("This author not exists");
        }

        Author author = read.get();

        entity.setAuthor(author);

        return articleRepository.save(entity);
    }

    @Override
    public Optional<Article> read(String id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> read() {
        return articleRepository.findAll();
    }

    @Override
    public Article update(Article entity, String id) {
        Optional<Article> oldRecord = read(id);

        if (!(oldRecord.isPresent())) {
            return create(entity);
        }

        Article oldRecordActual = oldRecord.get();

        Author oldAuthor = oldRecordActual.getAuthor();
        String oldId = oldRecordActual.getId();

        entity.setId(oldId);
        entity.setAuthor(oldAuthor);

        return articleRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        articleRepository.deleteById(id);
    }
}
