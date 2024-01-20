package main;

import com.google.gson.Gson;

public class Controller {
    Category cat = new Category();
    Area area = new Area();

    public Controller() {
        fill();
        RandomMeal();
    }

    public void fill() {
        cat.fill();
        area.fill();
    }

    public void SearchFood(String ing) {
        String URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i=" + ing;
        endResponse(URL);
    }

    private void endResponse(String URL) {
        String response = new UrlToJson(URL).getResponse();
        Gson gson = new Gson();
        Food.Meals meals = gson.fromJson(response, Food.Meals.class);

        if (meals != null) {
            Food[] foods = meals.getFoods();

            if (foods != null) {
                for (Food food : foods) {
                    System.out.println(food);
                }
            } else {
                System.out.println("No foods found");
            }
        } else {
            System.out.println("No meals found");
        }
    }

    public void RandomMeal() {
        String URL = "https://www.themealdb.com/api/json/v1/1/random.php";
        for (int i = 0; i < 10; i++) {
            endResponse(URL);
        }
    }

    public void fillMeals(String MealName) {
        String URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + MealName;
        String response = new UrlToJson(URL).getResponse();
        Gson gson = new Gson();
        Meal.FoodList meals = gson.fromJson(response, Meal.FoodList.class);

        if (meals != null) {
            Meal[] mealsList = meals.GetMeal();

            if (mealsList != null) {
                for (Meal meal : mealsList) {
                    System.out.println(meal);
                }
            } else {
                System.out.println("No meals found");
            }
        } else {
            System.out.println("No meals found");
        }
    }
}
