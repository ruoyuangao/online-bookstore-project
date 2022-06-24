<%--
  Created by IntelliJ IDEA.
  User: gry26
  Date: 4/20/2022
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <center>
        <br><br>
        <form action = "bookServlet?method=getBooks" method="post">
            Price:
            <input type="text" size="1" name="minPrice"/> -
            <input type="text" size="1" name="maxPrice"/>

            <input type="submit" value="Submit"/>
        </form>
        <br><br>
        <table>

            <c:forEach items="${bookpage.list}" var="book">
                <tr>
                    <td>
                        <a href="">${book.title} </a>
                        <br>
                        ${book.author}
                    </td>
                    <td>${book.price}</td>
                    <td><a href="">加入购物车</a></td>
                </tr>
            </c:forEach>
        </table>
        <br><br>
        共${bookpage.totalPageNumber}页
        &nbsp;&nbsp;
        当前第${bookpage.pageNo}页
        &nbsp;&nbsp;
        <c:if test="${bookpage.hasPrev}">
            <a href="bookServlet?method=getBooks&pageNo=1">首页</a>
            &nbsp;&nbsp;
            <a href="bookServlet?method=getBooks&pageNo=${bookpage.prevPage}">上一页</a>
        </c:if>
        &nbsp;&nbsp;
        <c:if test="${bookpage.hasNext}">
            <a href="bookServlet?method=getBooks&pageNo=${bookpage.nextPage}">下一页</a>
            &nbsp;&nbsp;
            <a href="bookServlet?method=getBooks&pageNo=${bookpage.totalPageNumber}">末页</a>
        </c:if>
    </center>

</body>
</html>
