package com.olehpodolin.recipeproject.repositories;

import com.olehpodolin.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
