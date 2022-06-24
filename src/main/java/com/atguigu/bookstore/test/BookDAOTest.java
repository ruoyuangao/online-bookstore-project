package com.atguigu.bookstore.test;

import com.atguigu.bookstore.CriteriaBook;
import com.atguigu.bookstore.Page;
import com.atguigu.bookstore.dao.BookDAO;
import com.atguigu.bookstore.dao.impl.BookDAOImpl;
import com.atguigu.bookstore.domain.Book;
import org.junit.Test;

public class BookDAOTest {

    private BookDAO bookDAO = new BookDAOImpl();

    @Test
    public void testGetBook(){
        Book book = bookDAO.getBook(5);
        System.out.println(book);
    }

    @Test
    public void testGetPage(){
//        CriteriaBook cb = new CriteriaBook(0, Integer.MAX_VALUE, 1);
        CriteriaBook cb = new CriteriaBook(50, 60, 90);
        Page<Book> page = bookDAO.getPage(cb);

        System.out.println("pageNo: "+page.getPageNo());
        System.out.println("totalPageNumber: " + page.getTotalPageNumber());
        System.out.println("list: "+ page.getList());
        System.out.println("prevPage: " + page.getPrevPage());
        System.out.println("nextPage: " + page.getNextPage());
    }

    @Test
    public void testGetTotalBookNumber(){
        int storeNubmer = bookDAO.getStoreNumber(5);
        System.out.println(storeNubmer);
    }

    @Test
    public void testGetPageList(){

    }


}
