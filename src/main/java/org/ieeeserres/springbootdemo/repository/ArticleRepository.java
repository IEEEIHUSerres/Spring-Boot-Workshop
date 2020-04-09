package org.ieeeserres.springbootdemo.repository;

import org.ieeeserres.springbootdemo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {
}
