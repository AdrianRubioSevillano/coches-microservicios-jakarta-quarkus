package es.upsa.dasi.common.adapters.rest.dtos;

import jakarta.json.bind.annotation.JsonbTransient;
import lombok.*;

import java.net.URI;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class CocheFullResponse {
    private long id;
    private String marca;
    private String modelo;
    private String anioLanzamiento;
    private int caballos;
    private String paginaWeb;

    @JsonbTransient
    private URI uri;
}