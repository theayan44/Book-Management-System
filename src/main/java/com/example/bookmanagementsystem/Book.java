package com.example.bookmanagementsystem;

public class Book {
    private String bookName;
    private int page;
    private String author_name;

    public String getBookName() {
        return bookName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page){
        this.page = page;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public Book(String bookName, int page, String author_name) {
        this.bookName = bookName;
        this.page = page;
        this.author_name = author_name;
    }

    @Override
    public String toString() {
        return "Book: {" +
                "bookName='" + bookName + '\'' +
                ", page=" + page +
                ", author_name=" + author_name +
                '}';
    }
}
