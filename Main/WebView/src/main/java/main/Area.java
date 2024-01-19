
package main;

import com.google.gson.Gson;

import java.util.List;

public class Area implements Filters {
    private List<AreaItem> meals;

    public List<AreaItem> getMeals() {
        return meals;
    }

    public void setMeals(List<AreaItem> meals) {
        this.meals = meals;
    }

    @Override
    public void fill() {
        String URL = "https://www.themealdb.com/api/json/v1/1/list.php?a=list";
        String response = new UrlToJson(URL).getResponse();
        Gson gson = new Gson();
        Area list = gson.fromJson(response, Area.class);
        setMeals(list.getMeals());

    }



    public static class AreaItem {
        private String strArea;

        public String getName() {
            return strArea;
        }
    }
}
