package com.example.demo.helper;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.BookJSON;
import com.example.demo.pojo.WallMessage;
import com.example.demo.pojo.WallMessageJSON;
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


    public WallMessage mapToPost(WallMessageJSON wallMessageJSON) {
        Assert.notNull(wallMessageJSON, "The wallMessageJSON must not be null");
        WallMessage wm = new WallMessage();
        // must not set id !
        wm.setTitle(wallMessageJSON.getTitle());
        wm.setContent(wallMessageJSON.getContent());
        return wm;
    }

    public WallMessageJSON mapToPost(WallMessage wallMessage) {
        Assert.notNull(wallMessage, "The wallMessage must not be null");
        WallMessageJSON wmJSON = new WallMessageJSON();
        wmJSON.setId(wallMessage.getId());
        wmJSON.setTitle(wallMessage.getTitle());
        wmJSON.setContent(wallMessage.getContent());
        return wmJSON;
    }

    public List<WallMessageJSON> mapToPost(List<WallMessage> wallMessageList) {
        Assert.notNull(wallMessageList, "The wallMessageList must not be null");
        return wallMessageList.stream().map(this::mapToPost).collect(Collectors.toList());
    }

}
