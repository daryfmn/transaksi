package ui.ft.ccit.faculty.transaksi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.domain.service.KaryawanService;
import ui.ft.ccit.faculty.transaksi.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController {

    private final KaryawanService karyawanService;

    public KaryawanController(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    @GetMapping
    @Operation(summary = "get all karyawan", description = "get all karyawan data")
    public List<Karyawan> getAll() {
        return karyawanService.getAll();
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Karyawan.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "get karyawan by id", description = "get karyawan details based on id")
    public Karyawan getById(@PathVariable String id) {
        return karyawanService.getById(id);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Karyawan.class)) }),
            @ApiResponse(responseCode = "409", description = "DATA_CONFLICT", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    @Operation(summary = "add new karyawan", description = "add new karyawan data into system")
    public Karyawan create(@RequestBody Karyawan karyawan) {
        return karyawanService.create(karyawan);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Karyawan.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "update karyawan", description = "update karyawan data based on id")
    public Karyawan update(@PathVariable String id, @RequestBody Karyawan karyawan) {
        return karyawanService.update(id, karyawan);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "delete karyawan", description = "delete karyawan data based on id")
    public void delete(@PathVariable String id) {
        karyawanService.delete(id);
    }
}