package com.example.bookmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public String addBook(Book book) {
        return bookRepository.addBook(book);
    }

    public String addAuthor(Author author) {
        return bookRepository.addAuthor(author);
    }

    public List<String> getListOfAuthorUnderGivenAgeAndWithGivenRating(int age, float rating) {
        return bookRepository.getListOfAuthorUnderGivenAgeAndWithGivenRating(age, rating);
    }

    public boolean updatePage(String bookName, int page) {
        return bookRepository.updatePage(bookName, page);
    }

    public List<Book> getAllBookDetails() {
        return bookRepository.getAllBookDetails();
    }

    public List<Author> getAllAuthorsDetails() {
        return bookRepository.getAllAuthorsDetails();
    }

    public Integer countOfBooksWithAuthorHavingRatingMoreThanX(float rating) {
        return bookRepository.countOfBooksWithAuthorHavingRatingMoreThanX(rating);
    }
}
