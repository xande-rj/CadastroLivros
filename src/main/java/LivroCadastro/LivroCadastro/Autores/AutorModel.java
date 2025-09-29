package LivroCadastro.LivroCadastro.Autores;

import java.util.ArrayList;

import LivroCadastro.LivroCadastro.Livros.LivroModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_autor")
public class AutorModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;

  // um auto para muitos Livros
  @OneToMany(mappedBy = "autor")
  private ArrayList<LivroModel> livros;

  AutorModel(String nome) {
    this.nome = nome;

  }

  AutorModel(String nome, ArrayList<LivroModel> livros) {
    this.nome = nome;
    this.livros = livros;
  }

}
