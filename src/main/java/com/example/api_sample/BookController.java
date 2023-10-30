package com.example.api_sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

	@Autowired
	BookMapper bookMapper;
	@Autowired
	AuthorMapper authorMapper;

	@QueryMapping
	public Book bookById(@Argument Integer id) {
		return bookMapper.getById(id);
	}

	@QueryMapping
	public List<Book> bookAll() {
		return bookMapper.findAll();
	}

	
	static int i = 0;
	// N+1問題
	@SchemaMapping
	public Author author(Book book) {
		System.out.println(++i);
		return authorMapper.getById(book.authorId());
	}
}