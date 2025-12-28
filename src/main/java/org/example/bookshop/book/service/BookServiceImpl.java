package org.example.bookshop.book.service;

import org.example.bookshop.dto.response.BookResponse;
import org.example.bookshop.dto.resquest.BookRequest;
import org.example.bookshop.excepion.RuleException;
import org.example.bookshop.model.Book;
import org.example.bookshop.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
    Optional<Book> byName =    bookRepository.findByName(bookRequest.getName());
    if(byName.isPresent()) {
        throw new RuleException("Book.already.exists");
    }
      Book save =  bookRepository.save(createBook(bookRequest));
      return createBookResponse(save);
    }

    @Override
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map((book) -> BookResponse.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build());
    }

    private Book createBook(BookRequest bookRequest){
           return Book.builder()
                   .name(bookRequest.getName())
                   .price(bookRequest.getPrice())
                   .build();
    }

    private BookResponse createBookResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }

}
