package me.kdshim.kdd_j.kona.tip.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.kdshim.kdd_j.kona.tip.model.Tip;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceSetDelivery {
    Tip tip;
    long minAmount;
    String status;
}
