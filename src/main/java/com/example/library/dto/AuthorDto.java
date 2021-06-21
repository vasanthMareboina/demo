package com.example.library.dto;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import java.util.List;

public class AuthorDto {


    private Integer authorId;
    private String name;
    private List<Book> book;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public AuthorDto(Integer authorId, String name, List<Book> book) {
        this.authorId = authorId;
        this.name = name;
        this.book = book;
    }

    public  AuthorDto(){

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (authorId != null ? !authorId.equals(author.getAuthorId()) : author.getAuthorId() != null) return false;
        if (name != null ? !name.equals(author.getName()) : author.getName() != null) return false;
        // if (book != null ? !book.equals(author.getBook()) : author.getBook() != null) return false;
        return book != null ? book.equals(author.getBook()) : author.getBook() == null;
        // return true;
    }

    @Override
    public int hashCode() {
        int result = authorId != null ? authorId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
    }

}
