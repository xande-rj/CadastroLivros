package LivroCadastro.LivroCadastro.Autores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AutorService {

  private final AutorRepository autorRepository;

  private AutorService(AutorRepository autorRepository) {
    this.autorRepository = autorRepository;
  }

  // listar Todos os autores
  public List<AutorModel> getAll() {
    return autorRepository.findAll();
  }

  // lista o autor pelo id
  public Optional<AutorModel> getById(Long id) {
    return autorRepository.findById(id);
  }

  // salva um autor
  public AutorModel save(AutorModel autorModel) {
    return autorRepository.save(autorModel);
  }

  // deleta um autor
  public void delete(Long id) {
    autorRepository.deleteById(id);
  }
}
