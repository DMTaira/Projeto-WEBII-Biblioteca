package com.web.biblioteca.membros;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class MembroService {
    private MembroRepository repository;
    public MembroService(MembroRepository repository){

        this.repository = repository;
    }

    public MembroRequest salvarMembro(MembroRequest membro) {
        if (repository.findByEmail(membro.getEmail()).isPresent()) {
            throw new RuntimeException("Usuário com esse email já está cadastrado!");
        }
        repository.save(new MembroEntity(membro));
        return membro;
    }
   public Iterable<MembroDto> getAll() {

        return MembroMapper.convertMembroEntityToDto(repository.findAll());
   }

    public MembroDto buscarMembroPorId(Long id) {
        MembroEntity membroEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membro não encontrado! ID: " + id));
        return MembroMapper.convertMembroEntityToDto(membroEntity);
    }
    public MembroRequest alterarMembro(Long id,MembroRequest membro) {
        Optional<MembroEntity> optionalMembroEntity = repository.findById(id);
        if (optionalMembroEntity.isPresent()) {
            MembroEntity membroEntityAlterado = optionalMembroEntity.get();
            membroEntityAlterado.setNomeCompleto(membro.getNomeCompleto());
            membroEntityAlterado.setEmail(membro.getEmail());
            membroEntityAlterado.setEndereco(membro.getEndereco());
            membroEntityAlterado.setNacionalidade(membro.getNacionalidade());
            membroEntityAlterado.setTelefone(membro.getTelefone());
            membroEntityAlterado.setDataNascimento(membro.getDataNascimento());
            membroEntityAlterado.setAlugou(membro.getAlugou());
            repository.save(membroEntityAlterado);
            return new MembroRequest(membroEntityAlterado);

        } else {
            throw new RuntimeException("Erro: membro nao alterado. ");
        }

    }

    public String deleteMembroPorId(@PathVariable Long id) {
        Optional<MembroEntity> optionalMembro = repository.findById(id);
        if (optionalMembro.isPresent()) {
            repository.deleteById(id);
            return "Membro deletado. ID: " + id;
        } else {
            throw new RuntimeException("Membro nao encontrado. " + id);
        }
    }
}

