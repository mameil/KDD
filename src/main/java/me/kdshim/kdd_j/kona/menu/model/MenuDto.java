package me.kdshim.kdd_j.kona.menu.model;

import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Method;

@Data
@Builder
public class MenuDto {
    int priority;
    boolean isMainMenu;
    String description;
    String imageUrl;
    String name;
    Method[] methods;
}
