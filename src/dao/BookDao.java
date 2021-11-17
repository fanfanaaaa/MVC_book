package dao;

import vo.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface BookDao {
    /**
     * @description:根据图书类别获取图书
     * @param category_id
     * @return: java.util.List<vo.Book>
     */
     public List<Book> getBookByCategory(int category_id) throws SQLException;
     /**
      * @description: 根据图书名称来获取图书
      * @param name
      * @return: java.util.List<vo.Book>
      */
     public List<Book> getBookByName(String name);
}
