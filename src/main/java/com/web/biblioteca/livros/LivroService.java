package com.web.biblioteca.livros;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {
    private LivroRepository repository;
    public LivroService(LivroRepository repository){

        this.repository = repository;
    }

    public LivroRequest salvarLivro(LivroRequest livroRequest){
        try {
            if (repository.findByIsbn(livroRequest.getIsbn()).isPresent()) {
                throw new RuntimeException("Livro com esse ISBN já está cadastrado!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir livro no banco de dados.", e);
        }
        repository.save(new LivroEntity(livroRequest));
        return livroRequest;
    }

    public Iterable<LivroDto> getAll() {

        return LivroMapper.convertLivroEntityToDto(repository.findAll());
    }

    public LivroRequest alterarLivro(Long id, LivroRequest livroRequest) {
        Optional<LivroEntity> optionalLivroEntity = repository.findById(id);
        if (optionalLivroEntity.isPresent()) {
            LivroEntity livroEntityAlterado = optionalLivroEntity.get();
            livroEntityAlterado.setTitulo (livroRequest.getTitulo());
            livroEntityAlterado.setAutor (livroRequest.getAutor());
            livroEntityAlterado.setGenero (livroRequest.getGenero());
            livroEntityAlterado.setAnoLancamento (livroRequest.getAnoLancamento());
            livroEntityAlterado.setIsbn (livroRequest.getIsbn());
            livroEntityAlterado.setQuantidade(livroRequest.getQuantidade());
            repository.save(livroEntityAlterado);
            return new LivroRequest(livroEntityAlterado);
        }
        else {
            throw new RuntimeException("Erro: livro nao alterado. ");
        }
    }


    public LivroDto buscarLivroPorId(Long id) {
        LivroEntity livroEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado! ID: " + id));
        return LivroMapper.convertLivroEntityToDto(livroEntity);

    }

    public String deleteLivroPorId(Long id) {
        Optional<LivroEntity> optionalLivro = repository.findById(id);
        if (optionalLivro.isPresent()) {
            repository.deleteById(id);
            return "Livro deletado. ID: " + id;
        } else {
            throw new RuntimeException("Livro nao encontrado. " + id);
        }
    }
}
