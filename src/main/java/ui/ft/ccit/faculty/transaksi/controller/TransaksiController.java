package ui.ft.ccit.faculty.transaksi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.domain.service.TransaksiService;
import ui.ft.ccit.faculty.transaksi.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    private final TransaksiService transaksiService;

    public TransaksiController(TransaksiService transaksiService) {
        this.transaksiService = transaksiService;
    }

    @GetMapping
    @Operation(summary = "get all transaksi", description = "get all transaksi data")
    public List<Transaksi> getAll() {
        return transaksiService.getAll();
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Transaksi.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "get transaksi by id", description = "get transaksi details based on kode transaksi")
    public Transaksi getById(@PathVariable String id) {
        return transaksiService.getById(id);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Transaksi.class)) }),
            @ApiResponse(responseCode = "409", description = "DATA_CONFLICT", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    @Operation(summary = "add new transaksi", description = "add new transaksi data into system")
    public Transaksi create(@RequestBody Transaksi transaksi) {
        return transaksiService.create(transaksi);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Transaksi.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "update transaksi", description = "update transaksi data based on kode transaksi")
    public Transaksi update(@PathVariable String id, @RequestBody Transaksi transaksi) {
        return transaksiService.update(id, transaksi);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "delete transaksi", description = "delete transaksi data based on kode transaksi")
    public void delete(@PathVariable String id) {
        transaksiService.delete(id);
    }
}