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
    //        if (cat.getMeals() != null && !cat.getMeals().isEmpty()) {
    //            for (Category.CategoryItem item : cat.getMeals()) {
    //                System.out.println(item.getName());
    //            }
    //        } else {
    //            System.out.println("No areas found");
    //        }

  }

  public void SearchFood(String ing) {
    String URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i=" + ing;
    endResponse(URL);
  }

  private void endResponse(String URL) {
    String response = new UrlToJson(URL).getResponse();
    Gson gson = new Gson();
    Food.Meals meals = gson.fromJson(response, Food.Meals.class);
    Food[] foods = meals.getFoods();
    for (Food food : foods) {
      System.out.println(food);
    }
  }

  public void RandomMeal() {
    String URL = "https://www.themealdb.com/api/json/v1/1/random.php";
    endResponse(URL);
  }

  public void fillMeals(String MealName) {
    String URL =
      "https://www.themealdb.com/api/json/v1/1/search.php?s=" + MealName;
    String response = new UrlToJson(URL).getResponse();
    Gson gson = new Gson();
    Meal.FoodList meals = gson.fromJson(response, Meal.FoodList.class);
    Meal[] mealsList = meals.GetMeal();
    for (Meal meal : mealsList) {
      System.out.println(meal);
    }
  }
}
