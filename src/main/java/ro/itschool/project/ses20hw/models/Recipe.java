package ro.itschool.project.ses20hw.models;

import lombok.Data;

import java.util.Set;

@Data
public class Recipe {

    private Set<String> ingredientSet;
    private DishType dishType;
}
