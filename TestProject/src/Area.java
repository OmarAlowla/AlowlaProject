import java.util.List;

public class Area {
    private List<AreaItem> meals;

    public List<AreaItem> getMeals() {
        return meals;
    }

    public static class AreaItem {
        private String strArea;

        public String getName() {
            return strArea;
        }
    }
}
