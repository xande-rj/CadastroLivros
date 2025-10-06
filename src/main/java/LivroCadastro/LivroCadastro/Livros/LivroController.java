package LivroCadastro.LivroCadastro.Livros;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

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

  @PatchMapping("/{id}")
  public LivroModel changeLivro(@RequestBody LivroModel livroMode, @PathVariable Long id) {
    Optional<LivroModel> obj = livrosService.getById(id);

    LivroModel lM = obj.get();

    if (livroMode.getNomeLivro() != null) {
      lM.setNomeLivro(livroMode.getNomeLivro());
    }
    if (livroMode.getGeneros() != null) {
      lM.setGeneros(livroMode.getGeneros());

    }
    lM.setData(LocalDateTime.now());
    return this.livrosService.save(lM);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    livrosService.delete(id);
  }
}
