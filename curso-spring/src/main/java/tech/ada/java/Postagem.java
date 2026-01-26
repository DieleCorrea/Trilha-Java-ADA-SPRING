package tech.ada.java;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Postagem {
  private UUID uudi;
  private String titulo;
  private String corpo;
  private LocalDate dataCriacao;
  private Usuario usuario;
}
