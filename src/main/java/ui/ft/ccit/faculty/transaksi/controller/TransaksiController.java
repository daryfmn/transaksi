package ui.ft.ccit.faculty.transaksi.controller;

import ui.ft.ccit.faculty.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.domain.service.TransaksiService;
import ui.ft.ccit.faculty.transaksi.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    private final TransaksiService transaksiService;

    public TransaksiController(TransaksiService transaksiService) {
        this.transaksiService = transaksiService;
    }

    // VIEW ALL TRANSAKSI
    @GetMapping
    @Operation(summary = "Mengambil daftar semua transaksi", description = "Mengambil seluruh data transaksi yang tersedia di sistem.\r\n"
            + //
            "Mendukung pagination opsional melalui parameter `page` dan `size`.")
    public List<Transaksi> list(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        // TANPA pagination
        if (page == null && size == null) {
            return transaksiService.getAll();
        }

        // DENGAN pagination
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 5;
        return transaksiService.getAllWithPagination(p, s);
    }

    // VIEW BASED ON ID
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

    // VIEW BASED ON WORD INPUT USING PARAMETER
    @GetMapping("/search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = Transaksi.class)) }),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = {
                    @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Pencarian transaksi tingkat lanjut", 
               description = "Mencari transaksi berdasarkan kode, tanggal, nama karyawan, atau nama pelanggan.")
    public List<Transaksi> search(
            @RequestParam(required = false) String kode,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate tgl,
            @RequestParam(required = false) String karyawan,
            @RequestParam(required = false) String pelanggan
    ) {
        return transaksiService.advancedSearch(kode, tgl, karyawan, pelanggan);
    }

    // CREATE TRANSAKSI
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

    // UPDATE BASED ON ID
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

    // DELETE BASED ON ID
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