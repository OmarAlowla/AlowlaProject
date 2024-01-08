import com.google.gson.Gson;

import java.util.List;

public class Controller {

    public  Controller ()
    {
        fill();
    }
    public void fill()
    {
        fillCat();
        fillArea();
    }

    public  void SearchFood(String ing,String cat,String area)
    
    {
        String test;
        String URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i="+ing+"&c="+cat+"&a="+area;
        String response = new UrlToJson(URL).getResponse();
        Gson gson = new Gson();
        Food.Meals meals = gson.fromJson(response, Food.Meals.class);
        Food[] foods = meals.getFoods();
        for (Food food : foods) {
            System.out.println(food );
        }
    }
    public  void fillMeals(String MealName)
    {
        String URL = "https://www.themealdb.com/api/json/v1/1/search.php?s="+MealName;
        String response = new UrlToJson(URL).getResponse();
        Gson gson = new Gson();
        Meal.FoodList meals = gson.fromJson(response, Meal.FoodList.class);
        Meal[] mealsList = meals.GetMeal();
        for (Meal meal : mealsList) {
            System.out.println(meal);
        }
    }
    public  void fillCat()
    {
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
    public  void fillArea()
    {
        String URL = "https://www.themealdb.com/api/json/v1/1/list.php?a=list";
        String response = new UrlToJson(URL).getResponse();
        Gson gson = new Gson();
        Area list = gson.fromJson(response, Area.class);
        List<Area.AreaItem> Areas = list.getMeals();

        if (!Areas.isEmpty()) {
            for (int i = 0; i < Areas.size(); i++) {
                System.out.println(Areas.get(i).getName());
            }
        } else {
            System.out.println("No categories found");
        }
    }
}
