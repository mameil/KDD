package me.kdshim.kdd_j.utils.impl;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.swagger.api.UtilsApiDelegate;
import me.kdshim.kdd_j.swagger.model.StringDto;
import me.kdshim.kdd_j.utils.UtilsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilsApiControllerImpl implements UtilsApiDelegate {
    private final UtilsService utilsService;


    @Override
    public ResponseEntity<StringDto> toStringToJSON(StringDto body) {
        StringDto dto = new StringDto();
        dto.setPlainString(utilsService.ToJson(body.getPlainString()));
        return ResponseEntity.ok(dto);
    }
}
