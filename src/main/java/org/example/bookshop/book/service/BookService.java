package org.example.bookshop.book.service;


import org.example.bookshop.dto.response.BookResponse;
import org.example.bookshop.dto.resquest.BookRequest;
import org.example.bookshop.model.Book;
import org.springframework.data.domain.Pageable;


public interface BookService {
    BookResponse save(BookRequest book);

    Page<BookResponse> findAll(Pageable pageable);
}
