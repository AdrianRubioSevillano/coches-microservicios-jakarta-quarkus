package es.upsa.dasi.common.adapters.rest.dtos;

import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class ErrorReponse {
    private String message;
    private String status;
}
