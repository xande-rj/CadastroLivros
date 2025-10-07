package LivroCadastro.LivroCadastro.Autores;

import java.util.ArrayList;
import java.util.List;

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
  private Long id;

  private String nome;

  // um autor para muitos Livros
  @ElementCollection
  @CollectionTable(name = "autorLivrosId", joinColumns = @JoinColumn(name = "autor_id"))
  @Column(name = "livrosId")
  private List<Integer> livrosId = new ArrayList<>();

}
