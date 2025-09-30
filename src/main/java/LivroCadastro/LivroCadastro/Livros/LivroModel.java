package LivroCadastro.LivroCadastro.Livros;

import LivroCadastro.LivroCadastro.Autores.AutorModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_cadastro_de_livros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LivroModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nomeLivro;
  private List<String> generos;
  private Calendar data = Calendar.getInstance();

  // muitos livros para um autor
  @ManyToOne
  @JoinColumn(name = "autor_id")
  @JsonBackReference
  private AutorModel autor;
}
