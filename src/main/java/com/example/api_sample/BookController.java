package com.example.api_sample;

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

	@SchemaMapping
	public Author author(Book book) {
		return authorMapper.getById(book.authorId());
	}
}