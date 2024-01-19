package com.example.SpringBoot.main;

import com.google.gson.Gson;

import java.util.List;

public class Category implements Filters {
    private List<CategoryItem> meals;

    public List<CategoryItem> getMeals() {
        return meals;
    }

    public void setMeals(List<CategoryItem> meals) {
        this.meals = meals;
    }

    @Override
    public void fill() {
        String URL = "https://www.themealdb.com/api/json/v1/1/list.php?c=list";
        String response = new UrlToJson(URL).getResponse();
        Gson gson = new Gson();
        Category list = gson.fromJson(response, Category.class);
        setMeals(list.getMeals());

    }



    public static class CategoryItem {
        private String strCategory;

        public String getName() {
            return strCategory;
        }
    }
}
