package com.example.demo.helper;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.BookJSON;
import com.example.demo.pojo.Member;
import com.example.demo.pojo.MemberJSON;
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
        wm.setDate(wallMessageJSON.getDate());
        wm.setAuthorId(wallMessageJSON.getAuthorId());
        return wm;
    }

    public WallMessageJSON mapToPost(WallMessage wallMessage) {
        Assert.notNull(wallMessage, "The wallMessage must not be null");
        WallMessageJSON wmJSON = new WallMessageJSON();
        wmJSON.setId(wallMessage.getId());
        wmJSON.setTitle(wallMessage.getTitle());
        wmJSON.setContent(wallMessage.getContent());
        wmJSON.setDate(wallMessage.getDate());
        wmJSON.setAuthorId(wallMessage.getAuthorId());
        return wmJSON;
    }

    public List<WallMessageJSON> mapToPost(List<WallMessage> wallMessageList) {
        Assert.notNull(wallMessageList, "The wallMessageList must not be null");
        return wallMessageList.stream().map(this::mapToPost).collect(Collectors.toList());
    }

	public Member mapToMember(MemberJSON memberJSON) {
        Assert.notNull(memberJSON, "The memberJson must not be null");
        Member m = new Member();
        m.setId(memberJSON.getId());
        m.setGroupId(memberJSON.getGroupId()); 
        m.setName(memberJSON.getName());
        m.setEmail(memberJSON.getEmail());
        return m;
	}

	public MemberJSON mapToMember(Member member) {
        Assert.notNull(member, "The member must not be null");
        MemberJSON mJSON = new MemberJSON();
        mJSON.setId(member.getId());
        mJSON.setGroupId(member.getGroupId()); 
        mJSON.setName(member.getName());
        mJSON.setEmail(member.getEmail());
        return mJSON;
    }
    
    public List<MemberJSON> mapToMember(List<Member> memberList) {
        Assert.notNull(memberList, "The memberList must not be null");
        return memberList.stream().map(this::mapToMember).collect(Collectors.toList());
    }

}
