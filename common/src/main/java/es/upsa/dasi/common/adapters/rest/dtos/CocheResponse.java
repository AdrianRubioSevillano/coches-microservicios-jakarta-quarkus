package es.upsa.dasi.common.adapters.rest.dtos;

import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class CocheResponse {
    private String marca;
    private String modelo;
    private int caballos;
    private String paginaWeb;
}
