
import com.hainam.petstore.dao.ProductDao;
import com.hainam.petstore.dto.Product;
import com.hainam.petstore.util.DBUtil;
import java.sql.Connection;
import java.util.*;

public class Main {

    private static ProductDao instance;
    private Connection conn = DBUtil.makeConnection();

    public static void main(String[] args) {
        ProductDao productDao = ProductDao.getInstance();
        List<Product> productList = productDao.getAllProduct();

        Set<String> categorySet = new HashSet<>();
        for (Product product : productList) {
            categorySet.add(product.getCategory());
        }

        List<String> categoryList = new ArrayList<>(categorySet);
        Collections.sort(categoryList);

        System.out.println("Categories: ");
        for (String category : categoryList) {
            System.out.println(category);
        }
    }
}
