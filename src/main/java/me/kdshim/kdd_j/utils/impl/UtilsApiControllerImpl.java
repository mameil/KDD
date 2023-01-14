package me.kdshim.kdd_j.utils.impl;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.swagger.api.UtilsApiDelegate;
import me.kdshim.kdd_j.swagger.model.StringDto;
import me.kdshim.kdd_j.utils.UtilsService;
import me.kdshim.kdd_j.utils.UtilsService2;
import me.kdshim.kdd_j.utils.UtilsService3;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilsApiControllerImpl implements UtilsApiDelegate {
    private final UtilsService utilsService;
    private final UtilsService2 utilsService2;
    private final UtilsService3 utilsService3;


    @Override
    public ResponseEntity<String> toStringToJSON(StringDto body) {
//        return ResponseEntity.ok(utilsService.toStringToJSON(body.getPlainString()));
        return ResponseEntity.ok(utilsService2.toStringToJSON(body.getPlainString()));
//        return ResponseEntity.ok(utilsService3.toStringToJSON(body.getPlainString()));
    }
}
