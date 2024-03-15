package com.web.biblioteca.emprestimos;


import com.web.biblioteca.livros.LivroEntity;
import com.web.biblioteca.livros.LivroRepository;
import com.web.biblioteca.membros.MembroEntity;
import com.web.biblioteca.membros.MembroRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

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
        Optional<MembroEntity> membroEntityOptional = membroRepository.findById(request.getMembro_id());
        if (!membroEntityOptional.isPresent()) {
            throw new RuntimeException("Membro não cadastrado!");
        }
        if (membroEntityOptional.get().getAlugou()) {
            throw new RuntimeException("Membro já tem livro emprestado!");
        }
        MembroEntity membroEntity = membroEntityOptional.get();
        Optional<LivroEntity> livroEntityOptional = livroRepository.findById(request.getLivro_id());

        if (!livroEntityOptional.isPresent()) {
            throw new RuntimeException("Livro não cadastrado!");
        }
        LivroEntity livroEntity = livroEntityOptional.get();

        if (livroEntity.getQuantidade() <= 0) {
            throw new RuntimeException("Livro não está disponível!");
        }
        request.setDataParaDevolucao(request.getDataInicial().plusDays(request.getPrazoEmDias()));

        emprestimoRepository.save(new EmprestimoEntity(request,membroEntity,livroEntity));

        livroEntity.setQuantidade(livroEntity.getQuantidade()+1);
        livroRepository.save(livroEntity);

        membroEntity.setAlugou(true);
        membroRepository.save(membroEntity);

        return request;

    }

    public Iterable<EmprestimoDto> getAll() {

        return EmprestimoMapper.convertEntityToDto(emprestimoRepository.findAll());
    }

    public Object buscarEmprestimoPorId(Long id) {

        EmprestimoEntity entity = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado! ID: " + id));
        return EmprestimoMapper.convertEntityToDto(entity);
    }


    public Object devolverEmprestimo(Long id, EmprestimoRequest request) {

        Optional<MembroEntity> membroEntityOptional = membroRepository.findById(request.getMembro_id());
        if (!membroEntityOptional.isPresent()) {
            throw new RuntimeException("Membro não cadastrado!");
        }
        MembroEntity membroEntity = membroEntityOptional.get();
        Optional<LivroEntity> livroEntityOptional = livroRepository.findById(request.getLivro_id());

        if (!livroEntityOptional.isPresent()) {
            throw new RuntimeException("Livro não cadastrado!");
        }
        LivroEntity livroEntity = livroEntityOptional.get();

        Optional<EmprestimoEntity> emprestimoEntity = emprestimoRepository.findById(id);
        request.setDataParaDevolucao(emprestimoEntity.orElseThrow().getDataParaDevolucao());

        if (request.getDataDevolucao().equals(null)) {
            request.setDataDevolucao(LocalDate.now());}

        if (request.getDataDevolucao().isAfter(request.getDataParaDevolucao())) {
            BigDecimal diasDeAtraso = BigDecimal.valueOf(ChronoUnit.DAYS.between(request.getDataParaDevolucao(),
                    request.getDataDevolucao()));
            request.setValorMulta(diasDeAtraso.multiply(request.getValorMultaDiaria()));
            request.setComentario("Emprestimo concluido com multa por atraso.");
        } else {
            request.setValorMulta(BigDecimal.ZERO);
            request.setComentario("Emprestimo devolvido no prazo.");
        }

        emprestimoRepository.save(new EmprestimoEntity(request,membroEntity,livroEntity));

        livroEntity.setQuantidade(livroEntity.getQuantidade()+1);
        livroRepository.save(livroEntity);

        membroEntity.setAlugou(false);
        membroRepository.save(membroEntity);

        return request;

    }


}
