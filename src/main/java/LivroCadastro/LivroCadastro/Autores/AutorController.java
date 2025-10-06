package LivroCadastro.LivroCadastro.Autores;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorController {

  // injecao de dependencia
  private final AutorService autorService;

  public AutorController(AutorService autorService) {
    this.autorService = autorService;
  }

  @GetMapping
  public List<AutorModel> getAll() {
    return autorService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<AutorModel> getById(@PathVariable Long id) {
    return autorService.getById(id);
  }

  // Rota de modificao de dados parcial
  @PatchMapping("/{id}")
  public AutorModel updateAutor(@PathVariable Long id, @RequestBody AutorModel autorModel) {
    Optional<AutorModel> obj = autorService.getById(id);

    AutorModel autorM = obj.get();

    if (autorModel.getNome() != null) {
      autorM.setNome(autorModel.getNome());
    }
    if (autorModel.getLivrosId() != null) {
      autorM.setLivrosId(autorModel.getLivrosId());
    }

    return this.autorService.save(autorM);
  }

  @PostMapping
  public AutorModel save(@RequestBody AutorModel autorModel) {
    System.out.println(autorModel);
    return autorService.save(autorModel);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    this.autorService.delete(id);
  }
}
