package main;

public class Food {

  private String strMeal;
  private String strMealThumb;
  private String strCategory;
  private String strArea;
  private String strInstructions;
  private String strYoutube;

  public Food(String strMeal, String strMealThumb) {
    this.strMeal = strMeal;
    this.strMealThumb = strMealThumb;
  }

  public String getStrMeal() {
    return strMeal;
  }

  public void setStrMeal(String strMeal) {
    this.strMeal = strMeal;
  }

  public String getStrMealThumb() {
    return strMealThumb;
  }

  public void setStrMealThumb(String strMealThumb) {
    this.strMealThumb = strMealThumb;
  }

  public String getStrCategory() {
    return strCategory;
  }

  public void setStrCategory(String strCategory) {
    this.strCategory = strCategory;
  }

  public String getStrArea() {
    return strArea;
  }

  public void setStrArea(String strArea) {
    this.strArea = strArea;
  }

  public String getStrInstructions() {
    return strInstructions;
  }

  public void setStrInstructions(String strInstructions) {
    this.strInstructions = strInstructions;
  }

  public String getStrYoutube() {
    return strYoutube;
  }

  public void setStrYoutube(String strYoutube) {
    this.strYoutube = strYoutube;
  }

  @Override
  public String toString() {
    return  strMeal + " ," + strMealThumb + " ," + strCategory
            + " ," + strArea + " ," + strYoutube ;
  }
}
