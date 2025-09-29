package LivroCadastro.LivroCadastro;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Calendar;

@Entity
@Table(name = "tb_cadastro_de_livros")

public class LivroModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nomeLivro;
  private ArrayList<String> genero;
  private Calendar calendario;
  private Date data = calendario.getTime();

  public LivroModel() {

  }

  public LivroModel(String nomeLivro, ArrayList<String> genero) {
    this.nomeLivro = nomeLivro;
    this.genero = genero;
  }
}
