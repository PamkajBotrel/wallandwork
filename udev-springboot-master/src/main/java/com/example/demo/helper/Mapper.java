package com.example.demo.helper;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.BookJSON;
import com.example.demo.pojo.Post;
import com.example.demo.pojo.PostJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public Book mapTo(BookJSON bookJSON) {
        Assert.notNull(bookJSON, "The bookJSON must not be null");
        Book b = new Book();
        // must not set id !
        b.setTitle(bookJSON.getTitle());
        b.setAuthor(bookJSON.getAuthor());
        return b;
    }

    public BookJSON mapTo(Book book) {
        Assert.notNull(book, "The book must not be null");
        BookJSON bJSON = new BookJSON();
        bJSON.setTitle(book.getTitle());
        bJSON.setAuthor(book.getAuthor());
        bJSON.setId(book.getId());
        return bJSON;
    }

    public List<BookJSON> mapTo(List<Book> bookList) {
        Assert.notNull(bookList, "The bookList must not be null");
        return bookList.stream().map(this::mapTo).collect(Collectors.toList());
    }


    public Post mapToPost(PostJSON postJSON) {
        Assert.notNull(postJSON, "The postJSON must not be null");
        Post b = new Post();
        // must not set id !
        b.setId(postJSON.getId());
        b.setTitle(postJSON.getTitle());
        b.setContent(postJSON.getContent());
        return b;
    }

    public PostJSON mapToPost(Post post) {
        Assert.notNull(post, "The post must not be null");
        PostJSON pJSON = new PostJSON();
        pJSON.setId(post.getId());
        pJSON.setTitle(post.getTitle());
        pJSON.setContent(post.getContent());
        return pJSON;
    }

    public List<PostJSON> mapToPost(List<Post> postList) {
        Assert.notNull(postList, "The postList must not be null");
        return postList.stream().map(this::mapToPost).collect(Collectors.toList());
    }

}
