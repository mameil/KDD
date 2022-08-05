package me.kdshim.kdd_j.kona;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mouth {
    String id;
    int version;
    List<Teeth> teethList;
    String name;

    @Override
    public String toString() {
        return "Mouth{" + "\n" +
                "id='" + id + '\'' + "\n" +
                ", version=" + version + "\n" +
                ", teethList=" + teethList + "\n" +
                ", name='" + name + '\'' + "\n" +
                '}' + "\n" ;
    }
}
