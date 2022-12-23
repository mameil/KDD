package me.kdshim.kdd_j.utils.impl;

import me.kdshim.kdd_j.swagger.api.UtilsApiDelegate;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import me.kdshim.kdd_j.swagger.model.StringDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UtilsApiControllerImpl implements UtilsApiDelegate {
    //di service

    @Override
    public ResponseEntity<StringDto> toStringToJSON(StringDto body) {
        return UtilsApiDelegate.super.toStringToJSON(body);
    }
}
