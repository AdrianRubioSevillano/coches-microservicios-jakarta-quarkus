package es.upsa.dasi.cochesjee.domain.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class Coche {
    private long id;
    private String marca;
    private String modelo;
    private String anioLanzamiento;
    private int caballos;
    private String paginaWeb;
}
