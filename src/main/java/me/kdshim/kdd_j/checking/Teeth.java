package me.kdshim.kdd_j.checking;

import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

@Setter
@Builder
@ToString
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

    public Teeth(String... tooth){
        System.out.println(tooth);
    }

    //JavaBeans Pattern
    public static void main(String[] args) {
        Teeth teeth = new Teeth();
        teeth.setFirst("THIS IS FIRST");
        teeth.setSecond("THIS IS SECOND");
        teeth.setThird("THIS IS THIRD");
        teeth.setFourth("THIS IS FOURTH");
        teeth.setFifth("THIS IS FIFTH");

        Teeth teeth2 = new Teeth("THIS IS FIRST", "THIS IS SECOND", "THIS IS THIRD", "THIS IS FOURTH", "THIS IS FIFITH");

        Teeth teeth3 = Teeth.builder()
                .first("THIS IS FIRST")
                .second("THIS IS SECOND")
                .third("THIS IS THIRD")
                .fourth("THIS IS FOURTH")
                .fifth("THIS IS FIFTH")
                .build();

        Teeth teeth4 = new Teeth("FIR");
        Teeth teeth5 = new Teeth("FIR", "SEC");

        System.out.println("first : " + teeth4.toString());
        System.out.println("sec : " + teeth5.toString());
    }
}

