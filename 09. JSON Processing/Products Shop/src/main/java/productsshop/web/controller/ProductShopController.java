package productsshop.web.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import productsshop.domain.dtos.CategorySeedDto;
import productsshop.domain.dtos.ProductInRangeDto;
import productsshop.domain.dtos.ProductSeedDto;
import productsshop.domain.dtos.UserSeedDto;
import productsshop.service.CategoryService;
import productsshop.service.ProductService;
import productsshop.service.UserService;
import productsshop.util.FileIOUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductShopController implements CommandLineRunner {
    private final static String USER_FILE_PATH =
            "/Users/kristiyan/IdeaProjects/Databases Frameworks - Hibernate & Spring Data - 2019/09. JSON Processing/Products Shop/src/main/resources/files/users.json";
    private final static String CATEGORY_FILE_PATH =
            "/Users/kristiyan/IdeaProjects/Databases Frameworks - Hibernate & Spring Data - 2019/09. JSON Processing/Products Shop/src/main/resources/files/categories.json";
    private final static String PRODUCT_FILE_PATH =
            "/Users/kristiyan/IdeaProjects/Databases Frameworks - Hibernate & Spring Data - 2019/09. JSON Processing/Products Shop/src/main/resources/files/products.json";

    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final FileIOUtil fileIOUtil;
    private final Gson gson;

    @Autowired
    public ProductShopController(UserService userService, CategoryService categoryService, ProductService productService, FileIOUtil fileIOUtil, Gson gson) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.fileIOUtil = fileIOUtil;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.seedUsers();
        //this.seedCategories();
        //this.seedProducts();
        this.productInRange();
    }

    private void productInRange() {
        List<ProductInRangeDto> productInRangeDtos = this.productService
                .productInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        String productInRangeJSON = this.gson.toJson(productInRangeDtos);

        System.out.println(productInRangeJSON);
    }

    private void seedProducts() throws IOException {
        String productFileContent = this.fileIOUtil
                .reedFile(PRODUCT_FILE_PATH);

        ProductSeedDto[] productSeedDtos = this.gson
                .fromJson(productFileContent, ProductSeedDto[].class);

        this.productService.seedProducts(productSeedDtos);
    }

    private void seedCategories() throws IOException {
        String categoryFileContent = this.fileIOUtil.reedFile(CATEGORY_FILE_PATH);

        CategorySeedDto[] categorySeedDtos = this.gson
                .fromJson(categoryFileContent, CategorySeedDto[].class);

        this.categoryService.seedCategories(categorySeedDtos);
    }

    private void seedUsers() throws IOException {
        String userFileContent = this.fileIOUtil.reedFile(USER_FILE_PATH);

        UserSeedDto[] userSeedDtos = this.gson
                .fromJson(userFileContent, UserSeedDto[].class);

        this.userService.seedUsers(userSeedDtos);
    }
}
