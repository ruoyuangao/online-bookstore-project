package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.CriteriaBook;
import com.atguigu.bookstore.Page;
import com.atguigu.bookstore.domain.Book;

import java.util.Collection;
import java.util.List;

public interface BookDAO {

    public abstract Book getBook(int id);
    public abstract Page<Book> getPage(CriteriaBook cb);
    long getTotalBookNumber(CriteriaBook cb);
    public abstract List<Book> getPageList(CriteriaBook cb, int pageSize);
    public abstract int getStoreNumber(Integer id);
//    public abstract void batchUpdateStoreNumberAndSalesAmount(
//            Collection<ShoppingCartItem> items);
}
