import com.google.gson.Gson;

import java.util.List;

public class Controller {
    Category cat = new Category();
    Area area = new Area();
    public  Controller ()
    {
        fill();
    }
    public void fill()
    {
        cat.fill();
        area.fill();
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

}
