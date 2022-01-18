package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.dto.BookRequestDto;
import com.bookstore.dto.BookResponseDto;
import com.bookstore.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/books")
	public String addBook(@RequestBody BookRequestDto bookRequestDto) {
		bookService.addBook(bookRequestDto);
		return "Book Data saved successfully";
	}
	
	@GetMapping("/books")
	public List<BookResponseDto> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/books/{bookId}")
	public BookResponseDto getBookById(@PathVariable Integer bookId) {
		return bookService.getBookById(bookId);
	}

}
