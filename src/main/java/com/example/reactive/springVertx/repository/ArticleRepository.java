package com.example.reactive.springVertx.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reactive.springVertx.bean.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

}
