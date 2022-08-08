package me.kdshim.kdd_j.kona.tip.model;

import lombok.Data;
import me.kdshim.kdd_j.kona.tip.model.Dong;

import java.util.List;

@Data
public class TipExtraDong {
    long tipAmount;
    List<Dong> dongList;
}
