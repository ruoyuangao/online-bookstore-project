package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.CriteriaBook;
import com.atguigu.bookstore.Page;
import com.atguigu.bookstore.dao.BookDAO;
import com.atguigu.bookstore.domain.Book;

import java.util.List;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {

    @Override
    public Book getBook(int id) {
        String sql = "SELECT id, author, title, price, publishingDate,"+
                "salesAmount, storeNumber, remark FROM mybooks WHERE id=?";
        return query(sql, id);
    }

    @Override
    public Page<Book> getPage(CriteriaBook cb) {
        Page page = new Page<>(cb.getPageNo());
        page.setTotalItemNumber(getTotalBookNumber(cb));
        //check page legal
        cb.setPageNo(page.getPageNo());
        page.setList(getPageList(cb,3));
        return page;

    }

    @Override
    public long getTotalBookNumber(CriteriaBook cb) {
        String sql = "SELECT count(id) FROM mybooks WHERE price >= ? AND price <= ?";
        return getSingleVal(sql, cb.getMinPrice(), cb.getMaxPrice());
    }

    @Override
    public List<Book> getPageList(CriteriaBook cb, int pageSize){
        String sql = "SELECT id, author, title, price, publishingDate, salesAmount, "
                +"storeNumber, remark FROM mybooks WHERE price >= ? AND price <= ?"
                +" LIMIT ?,?";
        return queryForList(sql, cb.getMinPrice(), cb.getMaxPrice(),
                (cb.getPageNo() - 1)*pageSize,pageSize);
    }

    @Override
    public int getStoreNumber(Integer id) {
        String sql = "SELECT storeNumber FROM mybooks WHERE id = ?";
        return getSingleVal(sql,id);
    }
}
