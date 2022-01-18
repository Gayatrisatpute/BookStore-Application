package com.bookstore.service;

import java.util.List;

import com.bookstore.dto.BookRequestDto;
import com.bookstore.dto.BookResponseDto;

public interface BookService {

	void addBook(BookRequestDto bookRequestDto);

	List<BookResponseDto> getAllBooks();

	BookResponseDto getBookById(Integer bookId);

}
