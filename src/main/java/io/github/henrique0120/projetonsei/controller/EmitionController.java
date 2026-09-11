package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestEmitionDTO;
import io.github.henrique0120.projetonsei.service.EmitionService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emition")
@AllArgsConstructor
public class EmitionController {

    private final EmitionService emitionService;

    @PostMapping
    public ResponseEntity<Object> emit(@RequestBody RequestEmitionDTO dto) throws BadRequestException {
        var sla = emitionService.emit(dto);
        return ResponseEntity.ok(sla);

    }



}
