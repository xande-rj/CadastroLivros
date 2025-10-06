package LivroCadastro.LivroCadastro.Livros;

import LivroCadastro.LivroCadastro.Autores.AutorModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_cadastro_de_livros")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LivroModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nomeLivro;
  private List<String> generos;
  private LocalDateTime data = LocalDateTime.now();

  // muitos livros para um autor
  @ManyToOne
  @JoinColumn(name = "autor_id")
  @JsonBackReference
  private AutorModel autor;
}
