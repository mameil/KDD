package me.kdshim.kdd_j.kona;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceSetDelivery {
    Tip tip;
    long minAmount;
    String status;
}
