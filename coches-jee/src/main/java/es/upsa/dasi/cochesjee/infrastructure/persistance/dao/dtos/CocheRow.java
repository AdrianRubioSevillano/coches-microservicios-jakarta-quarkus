package es.upsa.dasi.cochesjee.infrastructure.persistance.dao.dtos;

import lombok.*;

import java.time.LocalDate;


@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class CocheRow {
    private long id;
    private String marca;
    private String modelo;
    private String anioLanzamiento;
    private int caballos;
    private String paginaWeb;
}
