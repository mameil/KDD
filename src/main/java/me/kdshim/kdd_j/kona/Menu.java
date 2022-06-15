package me.kdshim.kdd_j.kona;

import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Method;

@Data
@Builder
public class Menu {
    String placeId;
    String id;
    int priority;
    boolean isMainMenu;
    String description;
    String imageUrl;
    String name;
    Method[] methods;
}
