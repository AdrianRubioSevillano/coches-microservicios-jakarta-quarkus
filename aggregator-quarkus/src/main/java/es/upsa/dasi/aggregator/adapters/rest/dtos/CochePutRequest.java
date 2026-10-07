package es.upsa.dasi.aggregator.adapters.rest.dtos;

import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class CochePutRequest {
    private String marca;
    private String modelo;
    private String anioLanzamiento;
    private int caballos;
    private String paginaWeb;
}

