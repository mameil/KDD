package me.kdshim.kdd_j.utils.impl;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.sender.AccountTrackerSender;
import me.kdshim.kdd_j.sender.dto.PostTransaction;
import me.kdshim.kdd_j.swagger.api.UtilsApiDelegate;
import me.kdshim.kdd_j.swagger.model.PostTranRequestDto;
import me.kdshim.kdd_j.swagger.model.PostTransResponseDto;
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
    private final JsonParser jsonParser;
    private final AccountTrackerSender accountTrackerSender;


    @Override
    public ResponseEntity<String> toStringToJSON(StringDto body) {
//        return ResponseEntity.ok(utilsService.toStringToJSON(body.getPlainString()));
//        return ResponseEntity.ok(utilsService2.toStringToJSON(body.getPlainString()));
//        return ResponseEntity.ok(utilsService3.toStringToJSON(body.getPlainString()));

        return ResponseEntity.ok(jsonParser.toJson(body.getPlainString()));
    }

    @Override
    public ResponseEntity<PostTransResponseDto> postTransaction() {
        accountTrackerSender.getCommitList(new PostTransaction(
                1000,
                "test",
                "2021-01-01 00:00:00",
                "20210101",
                "test from KDD",
                "test from KDD",
                1,
                "ERROR"
        ));
        return ResponseEntity.ok(new PostTransResponseDto());
    }
}
