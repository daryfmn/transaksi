package ui.ft.ccit.faculty.transaksi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.domain.service.PelangganService;
import ui.ft.ccit.faculty.transaksi.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

    private final PelangganService pelangganService;

    public PelangganController(PelangganService pelangganService) {
        this.pelangganService = pelangganService;
    }

    @GetMapping
    @Operation(summary = "get all pelanggan", description = "get all pelanggan data")
    public List<Pelanggan> getAll() {
        return pelangganService.getAll();
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pelanggan.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "get pelanggan by id", description = "get pelanggan details based on id")
    public Pelanggan getById(@PathVariable String id) {
        return pelangganService.getById(id);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pelanggan.class)) }),
            @ApiResponse(responseCode = "409", description = "DATA_CONFLICT", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    @Operation(summary = "add new pelanggan", description = "add new pelanggan data into system")
    public Pelanggan create(@RequestBody Pelanggan pelanggan) {
        return pelangganService.create(pelanggan);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pelanggan.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "update pelanggan", description = "update pelanggan data based on id")
    public Pelanggan update(@PathVariable String id, @RequestBody Pelanggan pelanggan) {
        return pelangganService.update(id, pelanggan);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "delete pelanggan", description = "delete pelanggan data based on id")
    public void delete(@PathVariable String id) {
        pelangganService.delete(id);
    }

}