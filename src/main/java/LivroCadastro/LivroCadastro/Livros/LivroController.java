package LivroCadastro.LivroCadastro.Livros;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

  // injecao de dependencia
  private final LivrosService livrosService;

  public LivroController(LivrosService livrosService) {
    this.livrosService = livrosService;
  }

  @GetMapping
  public List<LivroModel> getAll() {
    return livrosService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<LivroModel> getById(@PathVariable Long id) {
    return livrosService.getById(id);
  }

  @PostMapping
  public LivroModel create(@RequestBody LivroModel livroModel) {
    return livrosService.save(livroModel);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    livrosService.delete(id);
  }
}
