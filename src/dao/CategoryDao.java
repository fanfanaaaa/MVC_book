package dao;

import vo.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    /**
     * @description:添加书籍类别
     * @param category
     * @return: void
     */
    public void add(Category category);
    /**
     * @description:删除书籍类别
     * @param category
     * @return: void
     */
    public void delete(Category category);
    /**
     * @description: 查找书籍的全部类别
     * @param
     * @return: java.util.List<vo.Category>
     */
    public List<Category> findAll() throws SQLException;
    /**
     * @description:通过书籍类别名
     * @param id
     * @return: java.lang.String
     */
    public String getCategoryNameById(int id) throws SQLException;
}
