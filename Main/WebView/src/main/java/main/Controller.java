package main;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;

public class Controller {
    Category cat = new Category();
    Area area = new Area();
  public String[] randomArray;
  public String[] areaArray;
  public String[] catArray;

  int c = 0;

  List<AreaItem> areas;
  public Controller() {

    fill();
    RandomMeal();
  }

    public void fill() {
        cat.fill();
        area.fill();
        randomArray = new String[10];
        areas = area.getAreas();

        // Check if areas is not null before iterating
        if (areas != null) {
            for (AreaItem areaItem : areas) {
                System.out.println(areaItem.getName());
            }
        } else {
            System.out.println("Areas list is null");
        }
    }
  public void SearchFood(String ing) {
    String URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i=" + ing;
    endResponse(URL, "food");
  }

  private void endResponse(String URL, String type) {
    String response = new UrlToJson(URL).getResponse();
    Gson gson = new Gson();
    Meals meals = gson.fromJson(response, Meals.class);

    handleFood(meals != null, meals != null ? meals.getFoods() : null, type);
  }

  private void handleFood(boolean isNotNull, Food[] foods, String type) {
    c++;
    if (isNotNull && foods != null) {
      if (type.equals("food")) {
        Arrays.stream(foods).forEach(System.out::println);
      } else if (type.equals("random") && c < randomArray.length) {
        randomArray[c] = foods[0].toString();
      } else {
        System.out.println("Type unknown");
      }
    } else {
      System.out.println(
        "No " + (type.equals("food") ? "foods" : "meals") + " found"
      );
    }
  }

  public void RandomMeal() {
    String URL = "https://www.themealdb.com/api/json/v1/1/random.php";
    for (int i = 1; i <= 10; i++) {
      endResponse(URL, "random");
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
        Arrays.stream(mealsList).forEach(System.out::println);
      } else {
        System.out.println("No meals found");
      }
    } else {
      System.out.println("No meals found");
    }
  }
}
