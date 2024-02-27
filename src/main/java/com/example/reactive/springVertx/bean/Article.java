package com.example.reactive.springVertx.bean;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Article {

	@Id
	private Long id;
	private String article;
	private Article() {
		
	}
	public Article(Long id,String article) {
		super();
		this.id=id;
		this.article=article;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", article=" + article + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	
	
}
