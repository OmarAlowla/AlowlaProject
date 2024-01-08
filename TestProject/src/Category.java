import java.util.List;

public class Category {
    private List<CategoryItem> meals;

    public List<CategoryItem> getMeals() {
        return meals;
    }

    public static class CategoryItem {
        private String strCategory;

        public String getName() {
            return strCategory;
        }
    }
}
