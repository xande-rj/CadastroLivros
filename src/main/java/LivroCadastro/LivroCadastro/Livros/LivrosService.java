package LivroCadastro.LivroCadastro.Livros;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LivrosService {

  private final LivrosRepository livrosRepository;

  public LivrosService(LivrosRepository livrosRepository) {
    this.livrosRepository = livrosRepository;
  }

  // listar Todos os livros
  public List<LivroModel> getAll() {
    return livrosRepository.findAll();
  }

  public Optional<LivroModel> getById(Long id) {
    return livrosRepository.findById(id);
  }

  // salva um livro
  public LivroModel save(LivroModel livroModel) {
    return livrosRepository.save(livroModel);
  }

  // deleta um livro
  public void delete(Long id) {
    livrosRepository.deleteById(id);
  }
}
