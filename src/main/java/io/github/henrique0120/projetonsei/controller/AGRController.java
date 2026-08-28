package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestAgrDTO;
import io.github.henrique0120.projetonsei.mapper.AGRMapper;
import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.service.AGRService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/AGR")
@RequiredArgsConstructor
@Tag(name = "AGR")
public class AGRController implements GenericController{

    private final AGRService service;
    private final AGRMapper mapper;

    @PostMapping
    @PreAuthorize("hasRole('SUPORTE')")
    @Operation(summary = "Save", description = "Register")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Success!"),
            @ApiResponse(responseCode = "422", description = "Validation error!"),
            @ApiResponse(responseCode = "409", description = "AGR already registered!"),

    })
    public ResponseEntity<Object> registerAGR(@RequestBody @Valid RequestAgrDTO dto){
        AGR agr = mapper.toEntity(dto);
        service.registerAGR(agr);
        URI location = gerarHeaderLocation(agr.getId());
        return ResponseEntity.created(location).body("Registro de AGR feito com sucesso!");
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('SUPORTE')")
    @Operation(summary = "Update", description = "Update")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Update Success!"),
            @ApiResponse(responseCode = "422", description = "Validation Error!"),

    })
    public void updateAGR(@PathVariable("id") UUID id, @RequestBody AGR agr){
        service.updateAGR(id, agr);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('SUPORTE')")
    @Operation(summary = "Delete", description = "Delete")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Delete Success!"),
            @ApiResponse(responseCode = "404", description = "AGR not found!"),
            //@ApiResponse(responseCode = "400", description = "Autor possui livro cadastrado!"),

    })
    public void deleteAGR(@PathVariable("id") UUID id){
        service.deleteAGR(id);
    }

}
