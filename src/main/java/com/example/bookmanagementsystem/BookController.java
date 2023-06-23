package com.example.bookmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        String s = bookService.addBook(book);
        if(s != null)
            return new ResponseEntity("Book added successfully\n"+s, HttpStatus.CREATED);
        else
            return new ResponseEntity("Book already exist", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add-author")
    public ResponseEntity<String> addAuthor(@RequestBody Author author){
        String s = bookService.addAuthor(author);
        if(s != null)
            return new ResponseEntity("Author added successfully\n"+s, HttpStatus.CREATED);
        else
            return new ResponseEntity("Author already exist", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all-books")
    public ResponseEntity<List<Book>> getAllBookDetails(){
        List<Book> books= bookService.getAllBookDetails();
        return new ResponseEntity(books, HttpStatus.FOUND);
    }

    @GetMapping("/all-authors")
    public ResponseEntity<List<Author>> getAllAuthorsDetails(){
        List<Author> authors= bookService.getAllAuthorsDetails();
        return new ResponseEntity(authors, HttpStatus.FOUND);
    }

    @GetMapping("/get-list-of-author")
    public ResponseEntity<List<String>> getListOfAuthorUnderGivenAgeAndWithGivenRating(@RequestParam int age, @RequestParam float rating){
        List<String> authors = bookService.getListOfAuthorUnderGivenAgeAndWithGivenRating(age, rating);
        return new ResponseEntity(authors, HttpStatus.FOUND);
    }

    @PutMapping("/update-page/{bookName}/{page}")
    public ResponseEntity<String> updatePage(@PathVariable String bookName, @PathVariable int page){
        boolean isUpdated = bookService.updatePage(bookName, page);
        if(isUpdated)
            return new ResponseEntity("Page updated successfully", HttpStatus.CREATED);
        else
            return new ResponseEntity("Book not found", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/count-of-books-with-author-having-rating")
    public ResponseEntity<Integer> countOfBooksWithAuthorHavingRatingMoreThanX(@RequestParam float rating){
        Integer count = bookService.countOfBooksWithAuthorHavingRatingMoreThanX(rating);
        return new ResponseEntity(count, HttpStatus.FOUND);
    }
}
