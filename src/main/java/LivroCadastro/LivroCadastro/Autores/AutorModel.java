package LivroCadastro.LivroCadastro.Autores;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import LivroCadastro.LivroCadastro.Livros.LivroModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_autor")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AutorModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;

  // um auto para muitos Livros
  @OneToMany(mappedBy = "autor")
  @JsonManagedReference
  private List<LivroModel> livros;

}
