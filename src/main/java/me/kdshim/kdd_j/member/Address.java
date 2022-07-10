package me.kdshim.kdd_j.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    private String oldAddr;
    private String addr;
    private String addrDetail;
    private String zipCode;
}
