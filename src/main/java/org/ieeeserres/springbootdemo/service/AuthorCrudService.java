package org.ieeeserres.springbootdemo.service;

import org.ieeeserres.springbootdemo.entity.Author;
import org.ieeeserres.springbootdemo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorCrudService implements CrudService<Author> {

    private final AuthorRepository authorRepository;

    public AuthorCrudService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author entity) {
        return authorRepository.save(entity);
    }

    @Override
    public Optional<Author> read(String id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> read() {
        return authorRepository.findAll();
    }

    @Override
    public Author update(Author entity, String id) {
        Optional<Author> oldAuthor = read(id);

        if (!(oldAuthor.isPresent())) {
            return create(entity);
        }

        Author oldAuthorActual = oldAuthor.get();

        String oldId = oldAuthorActual.getId();

        entity.setId(oldId);

        return authorRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        authorRepository.deleteById(id);
    }
}
