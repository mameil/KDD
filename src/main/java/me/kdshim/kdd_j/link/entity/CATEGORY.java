package me.kdshim.kdd_j.link.entity;

public enum CATEGORY {
    JAVA("JAVA"), SPRING("SPRING"), FOOD("FOOD"), WORK("WORK"), KOTLIN("KOTLIN")
    ;

    private String value;

    CATEGORY(String value){
        this.value = value;
    }
    public static CATEGORY fromValue(String text){
        for (CATEGORY value : CATEGORY.values()) {
            if(value.value.equals(text))
                return value;
        }
        return null;
    }
}
