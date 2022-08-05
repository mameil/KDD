package me.kdshim.kdd_j.kona;

import lombok.Data;

import java.util.List;

@Data
public class TipExtraDong {
    long tipAmount;
    List<Dong> dongList;
}
