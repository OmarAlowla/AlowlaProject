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
    Meals meals = gson.fromJson(response, Meals.class);

    handleFood(meals != null, meals != null ? meals.getFoods() : null, "food");
  }

  private void endRandom(String URL) {
    String response = new UrlToJson(URL).getResponse();
    Gson gson = new Gson();
    RandomMeals randomMeals = gson.fromJson(response, RandomMeals.class);

    handleFood(
      randomMeals != null,
      randomMeals != null ? randomMeals.getFoods() : null,
      "random"
    );
  }

  private void handleFood(boolean isNotNull, Food[] foods, String type) {
    if (isNotNull) {
      if (foods != null) {
        if (type.equals("food")) {
          for (Food food : foods) {
            System.out.println(food);
          }
        } else if (type.equals("random")) {
          for (Food food : foods) {
            System.out.println(food);
          }
        } else {
          System.out.println("type unknown");
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
      endRandom(URL);
    }
  }

  public void fillMeals(String MealName) {
    String URL =
      "https://www.themealdb.com/api/json/v1/1/search.php?s=" + MealName;
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
