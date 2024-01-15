import com.google.gson.Gson;

import java.util.List;

public class Category implements Filters {
    private List<CategoryItem> meals;

    public List<CategoryItem> getMeals() {
        return meals;
    }

    @Override
    public void fill() {
        String URL = "https://www.themealdb.com/api/json/v1/1/list.php?c=list";
        String response = new UrlToJson(URL).getResponse();
        Gson gson = new Gson();
        Category list = gson.fromJson(response, Category.class);
        List<Category.CategoryItem> categories = list.getMeals();

        if (!categories.isEmpty()) {
            for (int i = 0; i < categories.size(); i++) {
                System.out.println(categories.get(i).getName());
            }
        } else {
            System.out.println("No categories found");
        }
    }

    public static class CategoryItem {
        private String strCategory;

        public String getName() {
            return strCategory;
        }
    }
}
