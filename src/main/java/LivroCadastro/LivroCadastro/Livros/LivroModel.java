package LivroCadastro.LivroCadastro.Livros;

import java.util.Date;

import LivroCadastro.LivroCadastro.Autores.AutorModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Calendar;

@Entity
@Table(name = "tb_cadastro_de_livros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LivroModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nomeLivro;
  private ArrayList<String> generos;
  private Calendar calendario;
  private Date data = calendario.getTime();

  // muitos livros para um autor
  @ManyToOne
  @JoinColumn(name = "autor_id")
  private AutorModel autor;

}
