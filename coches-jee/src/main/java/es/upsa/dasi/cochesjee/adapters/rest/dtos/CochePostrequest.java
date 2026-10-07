package es.upsa.dasi.cochesjee.adapters.rest.dtos;

import es.upsa.dasi.cochesjee.infrastructure.validation.Url;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class CochePostrequest {

    @NotBlank
    @Size(min = 3, max = 100)
    private String marca;

    @NotBlank
    @Size(min = 3, max = 100)
    private String modelo;

    @Size(min = 4, max = 4)
    @Digits(integer = 4, fraction = 0)
    private String anioLanzamiento;

    @Min(30)
    @Max(9999)
    private int caballos;

    @Url
    @Size(min = 15, max = 300)
    private String paginaWeb;
}