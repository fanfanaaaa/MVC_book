package service;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import vo.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private CategoryDao category = new CategoryDaoImpl();
    public List<Category> findAll() throws SQLException {
        return category.findAll();
    }
    public String getCategoryNameById(int id) throws SQLException {
        return category.getCategoryNameById(id);
    }
}
