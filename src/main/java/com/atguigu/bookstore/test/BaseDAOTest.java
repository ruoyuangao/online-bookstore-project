package com.atguigu.bookstore.test;

import com.atguigu.bookstore.dao.impl.BaseDAO;
import com.atguigu.bookstore.dao.impl.BookDAOImpl;
import com.atguigu.bookstore.domain.Book;
import org.junit.Test;


import java.sql.Date;
import java.util.List;


public class BaseDAOTest {

    private BookDAOImpl bookDAOImpl = new BookDAOImpl();

    private BaseDAO baseDAO = new BaseDAO();

    @Test
    public void testinsert() {
        String sql = "INSERT INTO trade (userid, tradetime) VALUES(?,?)";
        long id = baseDAO.insert(sql,1, new Date(new java.util.Date().getTime()));

        System.out.println(id);
    }

    @Test
    public void testupdate() {
        String sql = "UPDATE mybooks SET salesAmount = ? WHERE id = ?";
        bookDAOImpl.update(sql,10, 4);
    }

    @Test
    public void testquery() {
        String sql = "SELECT id, author, title, price, publishingDate,"+
                "salesAmount, storeNumber, remark FROM mybooks WHERE id = ?";
        Book book = bookDAOImpl.query(sql,4);
        System.out.println(book);
    }

    @Test
    public void testqueryForList() {
        String sql = "SELECT id, author, title, price, publishingDate,"+
                "salesAmount, storeNumber, remark FROM mybooks WHERE id < ?";
        List<Book> books = bookDAOImpl.queryForList(sql,4);
        System.out.println(books);
    }

    @Test
    public void testgetSingleVal() {
        String sql = "SELECT count(id) FROM mybooks";

        long count = bookDAOImpl.getSingleVal(sql);
        System.out.println(count);
    }

    @Test
    public void testbatch() {
        String sql = "UPDATE mybooks SET salesAmount = ?, storeNumber = ? WHERE id = ?";
        bookDAOImpl.batch(sql,new Object[]{1,1,1}, new Object[] {2,2,2}, new Object[]{3,3,3});
    }
}