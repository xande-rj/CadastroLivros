package LivroCadastro.LivroCadastro.Livros;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LivroController {

  @GetMapping("/helloWorld")
  public String helloWorld() {
    return "Ola mundo";
  }
}
