package LivroCadastro.LivroCadastro.Livros;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

  @PostMapping
  public LivroModel create(@RequestBody LivroModel livroModel) {
    return livrosService.save(livroModel);
  }

  @DeleteMapping
  public void delete(@RequestBody Long id) {
    livrosService.delete(id);
  }
}
