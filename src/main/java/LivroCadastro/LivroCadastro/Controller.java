package LivroCadastro.LivroCadastro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

  @GetMapping("/helloWorld")
  public String helloWorld() {
    return "Ola mundo";
  }
}
