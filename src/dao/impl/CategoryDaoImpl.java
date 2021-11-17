package dao.impl;

import dao.CategoryDao;
import utils.JdbcUtils;
import vo.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public void add(Category category) {

    }

    @Override
    public void delete(Category category) {

    }
    /**
     * @description: 查找书籍的全部类别
     * @param
     * @return: java.util.List<vo.Category>
     */
    @Override
    public List<Category> findAll() throws SQLException {
        Connection connection = null;
        Statement stat = null;
        List<Category> list = new ArrayList<Category>();

        try {
            connection = JdbcUtils.getConnection();
            stat = (Statement) connection.createStatement();
            String sql = "select id, name, description from category";
            ResultSet resultSet = (ResultSet) stat.executeQuery(sql);
            while (resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(connection);
        }
        return list;
        }

    @Override
    public String getCategoryNameById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet res = null;
        String name = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select name from category where category_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            res = preparedStatement.executeQuery();
            while (res.next()){
                name = res.getString("name");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(connection);
        }
        return name;

    }


}
