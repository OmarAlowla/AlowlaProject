package main;

import com.google.gson.Gson;
import java.util.List;

public class Category implements Filters {

  private List<CategoryItem> cats;

  public List<CategoryItem> getCats() {
    return cats;
  }

  public void setMeals(List<CategoryItem> meals) {
    this.cats = meals;
  }

  @Override
  public void fill() {
    String URL = "https://www.themealdb.com/api/json/v1/1/list.php?c=list";
    String response = new UrlToJson(URL).getResponse();
    Gson gson = new Gson();
    Category list = gson.fromJson(response, Category.class);
    setMeals(list.getCats());
  }


}
