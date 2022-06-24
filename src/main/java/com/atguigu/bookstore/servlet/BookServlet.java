package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.CriteriaBook;
import com.atguigu.bookstore.Page;
import com.atguigu.bookstore.domain.Book;
import com.atguigu.bookstore.service.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String pageNoStr = request.getParameter("pageNo");
        String minPriceStr = request.getParameter("minPrice");
        String maxPriceStr = request.getParameter("maxPrice");

        int pageNo = 1;
        int minPrice = 0;
        int maxPrice = Integer.MAX_VALUE;

        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            minPrice = Integer.parseInt(minPriceStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            maxPrice = Integer.parseInt(maxPriceStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        CriteriaBook criteriaBook = new CriteriaBook(minPrice, maxPrice, pageNo);

        Page<Book> page = bookService.getPage(criteriaBook);

        request.setAttribute("bookpage",page);

        request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request,response);


    }

}
