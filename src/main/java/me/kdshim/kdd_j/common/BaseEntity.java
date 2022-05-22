package me.kdshim.kdd_j.common;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {
    Date created;
    Date updated;
}
