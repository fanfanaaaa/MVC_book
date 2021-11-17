package dao.impl;

import dao.BookDao;
import utils.JdbcUtils;
import vo.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    @Override
    public List<Book> getBookByCategory(int category_id) throws SQLException {
        List<Book> list = new ArrayList<Book>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select * from book where category_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setCategory_id(resultSet.getInt("category_id"));
                book.setAuthor(resultSet.getString("author"));
                book.setDescription(resultSet.getString("description"));
                book.setPrice(resultSet.getFloat("price"));
                book.setName(resultSet.getString("name"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(connection);
        }
        return list;
    }

    @Override
    public List<Book> getBookByName(String name) {
        return null;
    }
}
