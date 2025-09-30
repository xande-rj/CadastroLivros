package LivroCadastro.LivroCadastro.Livros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LivroCadastro.LivroCadastro.Livros.LivrosService;

@RestController
@RequestMapping
public class LivroController {

  // injecao de dependencia
  private final LivrosService livrosService;

  public LivroController(LivrosService livrosService) {
    this.livrosService = livrosService;
  }

  @GetMapping("/helloWorld")
  public List<LivroModel> getAll() {
    return LivrosService.getAll();
  }

}
