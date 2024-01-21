package main;

import com.google.gson.Gson;
import java.util.List;

public class Area implements Filters {

  private List<AreaItem> areas;

  public List<AreaItem> getAreas() {
    return areas;
  }

  public void setAreas(List<AreaItem> areas) {
    this.areas = areas;
  }

  @Override
  public void fill() {
    String URL = "https://www.themealdb.com/api/json/v1/1/list.php?a=list";
    String response = new UrlToJson(URL).getResponse();
    Gson gson = new Gson();
    Area list = gson.fromJson(response, Area.class);
    setAreas(list.getAreas());
  }
}
