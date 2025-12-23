package ui.ft.ccit.faculty.transaksi.controller;

import ui.ft.ccit.faculty.transaksi.domain.service.JenisBarangService;
import ui.ft.ccit.faculty.transaksi.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jenis-barang")
public class JenisBarangController {

    private final JenisBarangService jenisBarangService;

    public JenisBarangController(JenisBarangService jenisBarangService) {
        this.jenisBarangService = jenisBarangService;
    }

    @GetMapping
    @Operation(summary = "get all jenis barang", description = "get all jenis barang data")
    public List<JenisBarang> getAll() {
        return jenisBarangService.getAll();
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JenisBarang.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "get jenis barang by id", description = "get jenis barang details based on id")
    public JenisBarang getById(@PathVariable Byte id) {
        return jenisBarangService.getById(id);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JenisBarang.class)) }),
            @ApiResponse(responseCode = "409", description = "DATA_CONFLICT", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    @Operation(summary = "add new jenis barang", description = "add new jenis barang data into system")
    public JenisBarang create(@RequestBody JenisBarang jenisBarang) {
        return jenisBarangService.create(jenisBarang);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JenisBarang.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "update jenis barang", description = "update jenis barang data based on id")
    public JenisBarang update(@PathVariable Byte id, @RequestBody JenisBarang jenisBarang) {
        return jenisBarangService.update(id, jenisBarang);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "delete jenis barang", description = "delete jenis barang data based on id")
    public void delete(@PathVariable Byte id) {
        jenisBarangService.delete(id);
    }

}