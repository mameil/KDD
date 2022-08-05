package me.kdshim.kdd_j.kona;

import lombok.Data;

import java.util.List;

@Data
public class Tip {
    List<TipGrade> tipGradeList;
    List<TipExtraDong> tipExtraDongList;
    List<TipExtraHour> tipExtraHourList;

}
