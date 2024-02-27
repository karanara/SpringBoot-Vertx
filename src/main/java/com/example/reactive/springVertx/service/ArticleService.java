package com.example.reactive.springVertx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reactive.springVertx.bean.Article;
import com.example.reactive.springVertx.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	public ArticleRepository articleRepository;
	
	public List<Article> getAllArticle(){
		return articleRepository.findAll();
	}
}
