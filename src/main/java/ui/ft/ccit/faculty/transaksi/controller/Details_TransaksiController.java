package ui.ft.ccit.faculty.transaksi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.model.Details_Transaksi;
import ui.ft.ccit.faculty.transaksi.domain.service.Details_TransaksiService;
import ui.ft.ccit.faculty.transaksi.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/details_transaksi")
public class Details_TransaksiController {

    private final Details_TransaksiService detailTransaksiService;

    public Details_TransaksiController(Details_TransaksiService detailTransaksiService) {
        this.detailTransaksiService = detailTransaksiService;
    }

    @GetMapping
    @Operation(summary = "get all detail transaksi", description = "get all detail transaksi data")
    public List<Details_Transaksi> getAll() {
        return detailTransaksiService.getAll();
    }

    @GetMapping("/{kodeTransaksi}/{idBarang}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Details_Transaksi.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "get detail transaksi by composite id", description = "get detail transaksi by kode transaksi and id barang")
    public Details_Transaksi getById(@PathVariable String kodeTransaksi, @PathVariable String idBarang) {
        return detailTransaksiService.getById(kodeTransaksi, idBarang);
    }

    @GetMapping("/transaksi/{kodeTransaksi}")
    @Operation(summary = "get details by kode transaksi", description = "get all detail transaksi for a specific transaksi")
    public List<Details_Transaksi> getByKodeTransaksi(@PathVariable String kodeTransaksi) {
        return detailTransaksiService.getByKodeTransaksi(kodeTransaksi);
    }

    @GetMapping("/barang/{idBarang}")
    @Operation(summary = "get details by id barang", description = "get all detail transaksi for a specific barang")
    public List<Details_Transaksi> getByIdBarang(@PathVariable String idBarang) {
        return detailTransaksiService.getByIdBarang(idBarang);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Details_Transaksi.class)) }),
            @ApiResponse(responseCode = "409", description = "DATA_CONFLICT", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    @Operation(summary = "add new detail transaksi", description = "add new detail transaksi data into system")
    public Details_Transaksi create(@RequestBody Details_Transaksi detailTransaksi) {
        return detailTransaksiService.create(detailTransaksi);
    }

    @PutMapping("/{kodeTransaksi}/{idBarang}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Details_Transaksi.class)) }),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "update detail transaksi", description = "update detail transaksi data")
    public Details_Transaksi update(@PathVariable String kodeTransaksi, @PathVariable String idBarang, 
                                   @RequestBody Details_Transaksi detailTransaksi) {
        return detailTransaksiService.update(kodeTransaksi, idBarang, detailTransaksi);
    }

    @DeleteMapping("/{kodeTransaksi}/{idBarang}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "DATA_NOT_FOUND", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @Operation(summary = "delete detail transaksi", description = "delete detail transaksi data")
    public void delete(@PathVariable String kodeTransaksi, @PathVariable String idBarang) {
        detailTransaksiService.delete(kodeTransaksi, idBarang);
    }

}