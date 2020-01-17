import cn.leo.travel.dao.CategoryDao;
import cn.leo.travel.dao.impl.CategoryDaoImpl;
import cn.leo.travel.domain.Category;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.List;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public class CategoryTest {


    @Test
    public void testFindAll() throws JsonProcessingException {
        CategoryDao categoryDao = new CategoryDaoImpl();

        List<Category> list = categoryDao.findAll();

        System.out.println(new ObjectMapper().writeValueAsString(list));

    }
}
