package me.kdshim.kdd_j.checking;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

public class GuavaTest {

    public static void main(String[] args) {
        Teeth t1 = new Teeth("1", "2","3","4","5","6");
        Teeth t2 = new Teeth("11", "12","13","14","15","16");
        Teeth t3 = new Teeth("12", "22","23","24","25","26");
        Teeth t4 = new Teeth("13", "32","33","34","35","36");

        List<Teeth> teethList = new ArrayList<>();
        teethList.add(t1);
        teethList.add(t2);
        teethList.add(t3);
        teethList.add(t4);

        Teeth tt1 = new Teeth("9", "8","7","6","5","4");
        Teeth tt2 = new Teeth("91", "82","73","64","55","46");
        Teeth tt3 = new Teeth("92", "82","73","64","55","46");
        Teeth tt4 = new Teeth("93", "82","73","64","55","46");

        List<Teeth> copyList = new ArrayList<>();
        teethList.add(tt1);
        teethList.add(tt2);
        teethList.add(tt3);
        teethList.add(tt4);


        Mouth m1 = Mouth.builder().name("mouth1").id("id1").version(0).teethList(teethList).build();
        Mouth m2 = Mouth.builder().name("mouth2").id("id2").version(0).teethList(copyList).build();
        Mouth m3 = Mouth.builder().name("mouth3").id("id3").version(0).teethList(teethList).build();

        List<Mouth> mlist1 = new ArrayList<>();
        mlist1.add(m1);mlist1.add(m2);

        List<Mouth> mlist2 = new ArrayList<>();
        mlist2.add(m1); mlist2.add(m3);

        Set<Mouth> fromList = Sets.newHashSet(mlist2);
        fromList.forEach(System.out::println);
    }
}
