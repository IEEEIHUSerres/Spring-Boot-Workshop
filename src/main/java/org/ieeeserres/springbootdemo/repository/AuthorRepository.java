package org.ieeeserres.springbootdemo.repository;

import org.ieeeserres.springbootdemo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
}
