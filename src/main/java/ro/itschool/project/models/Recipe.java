package ro.itschool.project.models;

import lombok.Data;

import java.util.Set;

@Data
public class Recipe {

    private Set<String> ingredientSet;
    private DishTypeEnum dishTypeEnum;
}
