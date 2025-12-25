package ui.ft.ccit.faculty.transaksi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

        /*
         * ======================================================
         * GLOBAL METADATA
         * ======================================================
         */
        @Bean
        public OpenAPI openAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("API Sistem Transaksi")
                                                .version("1.0.0")
                                                .description("""
                                                                Dokumentasi API internal Sistem Transaksi.

                                                                Catatan desain:
                                                                - API berbasis REST
                                                                - Pagination opsional
                                                                - Bulk operation bersifat transactional
                                                                - Swagger hanya sebagai dokumentasi manusia
                                                                """)
                                                .contact(new Contact()
                                                                .name("Muhammad Azka Ramadhan")
                                                                .email("m.azka@eng.ui.ac.id")));
        }

        /*
         * ======================================================
         * GROUP: BARANG
         * ======================================================
         */
        @Bean
        public GroupedOpenApi barangApi() {
                return GroupedOpenApi.builder()
                                .group("Barang")
                                .pathsToMatch("/api/barang/**")
                                .build();
        }

        @Bean
        public GroupedOpenApi jenisBarangApi() {
                return GroupedOpenApi.builder()
                                .group("JenisBarang")
                                .pathsToMatch("/api/jenis_barang/**")
                                .build();
        }

        @Bean
        public GroupedOpenApi karyawanApi() {
                return GroupedOpenApi.builder()
                                .group("Karyawan")
                                .pathsToMatch("/api/karyawan/**")
                                .build();
        }

        @Bean
        public GroupedOpenApi pemasokApi() {
                return GroupedOpenApi.builder()
                                .group("Pemasok")
                                .pathsToMatch("/api/pemasok/**")
                                .build();
        }

        @Bean
        public GroupedOpenApi pelangganApi() {
                return GroupedOpenApi.builder()
                                .group("Pelanggan")
                                .pathsToMatch("/api/pelanggan/**")
                                .build();
        }

        @Bean
        public GroupedOpenApi transaksiApi() {
                return GroupedOpenApi.builder()
                                .group("Transaksi")
                                .pathsToMatch("/api/transaksi/**")
                                .build();
        }

        @Bean
        public GroupedOpenApi detailsTransaksiApi() {
                return GroupedOpenApi.builder()
                                .group("Details Transaksi")
                                .pathsToMatch("/api/details_transaksi/**")
                                .build();
        }
}
