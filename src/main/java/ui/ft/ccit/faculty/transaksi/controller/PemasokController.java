package ui.ft.ccit.faculty.transaksi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.domain.service.PemasokService;
import ui.ft.ccit.faculty.transaksi.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pemasok")
public class PemasokController {

    private final PemasokService pemasokService;

    public PemasokController(PemasokService pemasokService) {
        this.pemasokService = pemasokService;
    }

    @GetMapping
    @Operation(summary = "get all pemasok", description = "get all pemasok data")
    public List<Pemasok> getAll() {
        return pemasokService.getAll();
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pemasok.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "get pemasok by id", description = "get pemasok details based on id")
    public Pemasok getById(@PathVariable String id) {
        return pemasokService.getById(id);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pemasok.class)) }),
            @ApiResponse(responseCode = "409", description = "DATA_CONFLICT", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    @Operation(summary = "add new pemasok", description = "add new pemasok data into system")
    public Pemasok create(@RequestBody Pemasok pemasok) {
        return pemasokService.create(pemasok);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pemasok.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "update pemasok", description = "update pemasok data based on id")
    public Pemasok update(@PathVariable String id, @RequestBody Pemasok pemasok) {
        return pemasokService.update(id, pemasok);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "delete pemasok", description = "delete pemasok data based on id")
    public void delete(@PathVariable String id) {
        pemasokService.delete(id);
    }

}