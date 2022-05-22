package me.kdshim.kdd_j.recipe.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Recipe {
    @Id
    String name;
}
