package main;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;

public class Controller {
  Category cat = new Category();
  Area area = new Area();
  public String[] randomArray;
  public String[] randomInstructions;
  public String[] areaArray;
  public String[] catArray;

  int c = 0;

  List<AreaItem> areas;
  public Controller() {
    fill();
  }

  public void fill() {
    cat.fill();
    area.fill();
    areaArray = new String[30];
    catArray = new String[30];
    randomArray = new String[10];
    randomInstructions = new String[10];

    for (CategoryItem categoryItem : cat.getMeals()) {
      catArray[c] = categoryItem.getName();
      c++;
    }
    c = 0;
    for (AreaItem areaItem : area.getMeals()) {
      areaArray[c] = areaItem.getName();
      c++;
    }
    c = 0;
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
    if (isNotNull && foods != null) {
      if (type.equals("food")) {
        Arrays.stream(foods).forEach(System.out::println);
      } else if (type.equals("random") && c < randomArray.length) {
        if (c == 10 || c > 10) {
          c=0;
        }
        randomArray[c] = foods[0].toString();
        randomInstructions[c] = foods[0].getStrInstructions();

      }
    } else {
      System.out.println(
              "No " + (type.equals("food") ? "foods" : "meals") + " found"
      );
    }
    c++;
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