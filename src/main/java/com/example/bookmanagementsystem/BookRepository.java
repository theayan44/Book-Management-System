package com.example.bookmanagementsystem;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepository {
    HashMap<String, Book> bookDb = new HashMap<>();
    HashMap<String, Author> authorDb = new HashMap<>();
    public String addBook(Book book) {
        if(bookDb.containsKey(book.getBookName()))
            return null;
        bookDb.put(book.getBookName(), book);
        return book.toString();
    }

    public String addAuthor(Author author) {
        if(authorDb.containsKey(author.getName()))
            return null;
        authorDb.put(author.getName(), author);
        return author.toString();
    }

    public List<Book> getAllBookDetails() {
        List<Book> books = new ArrayList<>();
        for(String bookName : bookDb.keySet()){
            books.add(bookDb.get(bookName));
        }
        return books;
    }

    public List<Author> getAllAuthorsDetails() {
        List<Author> authors = new ArrayList<>();
        for(String authorName : authorDb.keySet()){
            authors.add(authorDb.get(authorName));
        }
        return authors;
    }

    public List<String> getListOfAuthorUnderGivenAgeAndWithGivenRating(int age, float rating) {
        List<String> authors = new ArrayList<>();
        for(String author : authorDb.keySet()){
            Author currAuthor = authorDb.get(author);
            if(currAuthor.getAge() <= age && currAuthor.getRating() > rating)
                authors.add(currAuthor.getName());
        }
        return authors;
    }

    public boolean updatePage(String bookName, int page) {
        if(!bookDb.containsKey(bookName))
            return false;
        bookDb.get(bookName).setPage(page);
        return true;
    }

    public Integer countOfBooksWithAuthorHavingRatingMoreThanX(float rating) {
        int count = 0;
        for(String book : bookDb.keySet()){
            String authorNmae = bookDb.get(book).getAuthor_name();
            if(authorDb.containsKey(authorNmae) && authorDb.get(authorNmae).getRating() > rating)
                count++;
        }
        return count;
    }
}
