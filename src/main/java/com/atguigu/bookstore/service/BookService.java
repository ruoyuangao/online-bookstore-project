package com.atguigu.bookstore.service;

import com.atguigu.bookstore.CriteriaBook;
import com.atguigu.bookstore.Page;
import com.atguigu.bookstore.dao.BookDAO;
import com.atguigu.bookstore.dao.impl.BookDAOImpl;
import com.atguigu.bookstore.domain.Book;

public class BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    public Page<Book> getPage(CriteriaBook criteriaBook){
        return bookDAO.getPage(criteriaBook);
    }
}
