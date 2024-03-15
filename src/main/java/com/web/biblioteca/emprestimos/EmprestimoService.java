package com.web.biblioteca.emprestimos;


import com.web.biblioteca.livros.LivroRepository;
import com.web.biblioteca.membros.MembroRepository;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {
    EmprestimoRepository emprestimoRepository;
    MembroRepository membroRepository;
    LivroRepository livroRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             MembroRepository membroRepository,
                             LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.membroRepository = membroRepository;
        this.livroRepository = livroRepository;
    }

    public Object salvarEmprestimo(EmprestimoRequest request) {
        return null;

    }

    public Iterable<EmprestimoDto> getAll() {

        return EmprestimoMapper.convertEntityToDto(emprestimoRepository.findAll());
    }

    public Object buscarEmprestimoPorId(Long id) {

        EmprestimoEntity entity = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado! ID: " + id));
        return EmprestimoMapper.convertEntityToDto(entity);
    }


    public Object alterarEmprestimo(Long id, EmprestimoRequest emprestimoRequest) {
        return null;
    }

    public Object deleteEmprestimoPorId(Long id) {
        return null;
    }
}
