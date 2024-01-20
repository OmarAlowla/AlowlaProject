package main;

public class RandomFood extends Food {

  private String strMeal;
  private String strMealThumb;

  public RandomFood(String strMeal, String strMealThumb) {
    super(strMeal, strMealThumb);
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

  @Override
  public String toString() {
    return "Food [strMeal=" + strMeal + ", strMealThumb=" + strMealThumb + "]";
  }
}
