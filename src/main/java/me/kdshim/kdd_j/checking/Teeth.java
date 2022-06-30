package me.kdshim.kdd_j.checking;

import lombok.Setter;

@Setter
public class Teeth {
    String first;
    String second;
    String third;
    String fourth;
    String fifth;
    String sixth;

    public Teeth() {
    }

    public Teeth(String first) {
        this(first, null, null, null, null, null);
    }

    public Teeth(String first, String second) {
        this(first, second, null, null, null, null);
    }

    public Teeth(String first, String second, String third) {
        this(first, second, third, null, null, null);

    }

    public Teeth(String first, String second, String third, String fourth) {
        this(first, second, third, fourth, null, null);
    }

    public Teeth(String first, String second, String third, String fourth, String fifth) {
        this(first, second, third, fourth, fifth, null);
    }

    public Teeth(String first, String second, String third, String fourth, String fifth, String sixth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
    }

    //JavaBeans Pattern
//    public static void main(String[] args) {
//        Teeth teeth = new Teeth();
//        teeth.setFirst("THIS IS FIRST");
//        teeth.setSecond("THIS IS SECOND");
//        teeth.setThird("THIS IS THIRD");
//        teeth.setFourth("THIS IS FOURTH");
//        teeth.setFifth("THIS IS FIFTH");
//
//    }
}

