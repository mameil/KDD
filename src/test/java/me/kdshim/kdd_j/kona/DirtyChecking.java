package me.kdshim.kdd_j.kona;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import me.kdshim.kdd_j.kona.tip.model.PlaceSetDelivery;
import org.springframework.beans.factory.annotation.Autowired;

public class DirtyChecking extends MyMockMvc {
    @Autowired
    ObjectMapper objectMapper;

    @KDTest
    public void tipCheck() throws Exception{
        String req = "{\"tip\":{\"tipGradeList\":[{\"baseAmount\":0,\"tipAmount\":1000},{\"baseAmount\":1000,\"tipAmount\":2000}],\"tipExtraDongList\":[{\"tipAmount\":100,\"dongList\":[{\"name\":\"망원동1\",\"kaId\":\"mang1\"},{\"name\":\"망원동2\",\"kaId\":\"mang2\"}]},{\"tipAmount\":200,\"dongList\":[{\"name\":\"포동\",\"kaId\":\"young1\"},{\"name\":\"영등포동2\",\"kaId\":\"young2\"},{\"name\":\"가상동2\",\"kaId\":\"kasang2\"}]}],\"tipExtraHourList\":[{\"days\":[\"SAT\",\"MON\"],\"fromTime\":\"18:00\",\"toTime\":\"20:00\",\"amount\":1000},{\"days\":[\"SAT\",\"SUN\",\"TUE\"],\"fromTime\":\"18:00\",\"toTime\":\"23:59\",\"amount\":3000},{\"days\":[\"SAT\",\"SUN\",\"MON\",\"TUE\",\"WED\",\"THU\",\"FRI\"],\"fromTime\":\"18:00\",\"toTime\":\"23:59\",\"amount\":500},{\"days\":[\"SUN\"],\"fromTime\":\"18:00\",\"toTime\":\"23:59\",\"amount\":100000}]},\"minAmount\":10,\"status\":\"NONE\"}";

        PlaceSetDelivery placeSetDelivery = objectMapper.readValue(req, PlaceSetDelivery.class);
        System.out.println(placeSetDelivery.toString());


    }
}
