package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dto.BookRequestDto;
import com.bookstore.dto.BookResponseDto;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public void addBook(BookRequestDto bookRequestDto) {

		Book book = new Book();
		BeanUtils.copyProperties(bookRequestDto, book);
		bookRepository.save(book);
	}

	@Override
	public List<BookResponseDto> getAllBooks() {
		List<BookResponseDto> bookReponseList = new ArrayList<>();
		Iterator it = bookRepository.findAll().iterator();
		while (it.hasNext()) {
			BookResponseDto responseDto = new BookResponseDto();
			BeanUtils.copyProperties(it.next(), responseDto);
			bookReponseList.add(responseDto);
		}
		return bookReponseList;
	}

	@Override
	public BookResponseDto getBookById(Integer bookId) {
		Book book = new Book();
		BookResponseDto bookResponseDto = new BookResponseDto();
		Optional<Book> optionalBook = bookRepository.findById(bookId);

		if (optionalBook.isPresent())
			book = optionalBook.get();

		BeanUtils.copyProperties(book, bookResponseDto);
		return bookResponseDto;
	}
}
