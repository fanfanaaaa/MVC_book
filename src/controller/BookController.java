package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.BookService;
import service.CategoryService;
import utils.JdbcUtils;
import vo.Book;
import vo.Category;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookController", value = "/BookController")
public class BookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookService();
        int id = Integer.parseInt(request.getParameter("id"));

        CategoryService categoryService = new CategoryService();
        List<Category> list = null;

        try {
            list = categoryService.findAll();
            List<Book> bookList = bookService.getBookByCategory(id);
            request.setAttribute("categories", list);
            request.setAttribute("books", bookList);
            request.getRequestDispatcher("/main.jsp").forward(request,response);

            // 使用json传输数据
            response.setCharacterEncoding("utf-8");
            ObjectMapper mapper = new ObjectMapper();
            String jsonStr = mapper.writeValueAsString(bookList);
            PrintWriter out = response.getWriter();
            out.write(jsonStr);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
