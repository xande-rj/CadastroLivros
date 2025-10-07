package LivroCadastro.LivroCadastro.Autor.Repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import LivroCadastro.LivroCadastro.Autores.AutorModel;
import LivroCadastro.LivroCadastro.Autores.AutorRepository;
import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class AutorRepositoryTest {

  @Autowired
  EntityManager entityManager;

  @Autowired
  AutorRepository autorRepository;

  private AutorModel createAutorModel() {

    AutorModel newAutorModel = new AutorModel();
    newAutorModel.setNome("alexandre");
    System.out.println(newAutorModel.getId());
    this.entityManager.persist(newAutorModel);
    return newAutorModel;
  }

  @Test
  @DisplayName("Test de Repository")
  void getAll() {
    this.createAutorModel();

    List<AutorModel> result = this.autorRepository.findAll();
    assertThat(result)
        .anyMatch(l -> "alexandre".equals(l.getNome()));
  }

  @Test
  @DisplayName("Test de Id")
  void findById() {

    AutorModel obj = this.createAutorModel();

    Optional<AutorModel> result = this.autorRepository.findById(obj.getId());

    assertThat(result.isPresent()).isTrue();
  }

  @Test
  @DisplayName("Test de delete")
  void deleteById() {

    AutorModel obj = this.createAutorModel();

    this.autorRepository.deleteById(obj.getId());
    List<AutorModel> result = this.autorRepository.findAll();
    assertThat(result).isEmpty();

  }

  @Test
  @DisplayName("Teste de Pacth")
  void changeAutor() {
    AutorModel createAutor = this.createAutorModel();
    Optional<AutorModel> obj = this.autorRepository.findById(createAutor.getId());

    AutorModel newAutor = obj.get();

    newAutor.setNome("Fernando");

    this.autorRepository.save(newAutor);

    assertThat(obj).isPresent();
    assertThat(obj.get().getNome()).isEqualTo("Fernando");
  }
}
