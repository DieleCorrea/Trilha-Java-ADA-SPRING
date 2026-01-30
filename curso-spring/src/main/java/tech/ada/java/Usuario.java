package tech.ada.java;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
 private UUID uuid;
 private String nome;
 private String emaii;
 private LocalDate dob;



 // Criar uma api Rest
}