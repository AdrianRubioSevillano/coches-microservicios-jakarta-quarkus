package es.upsa.dasi.cochesjee.domain.model;

import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class AddCocheCommand {
    private String marca;
    private String modelo;
    private String anioLanzamiento;
    private int caballos;
    private String paginaWeb;
}
