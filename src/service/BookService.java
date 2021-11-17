package service;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import vo.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookDao book = new BookDaoImpl();
    public List<Book> getBookByCategory(int category_id) throws SQLException {
        return book.getBookByCategory(category_id);
    }
}
