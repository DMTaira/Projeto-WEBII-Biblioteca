package com.web.biblioteca.emprestimos;


import com.web.biblioteca.livros.LivroEntity;
import com.web.biblioteca.livros.LivroRepository;
import com.web.biblioteca.membros.MembroEntity;
import com.web.biblioteca.membros.MembroRepository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoMapper {
    LivroRepository livroRepository;
    MembroRepository membroRepository;
    public EmprestimoMapper(LivroRepository livroRepository, MembroRepository membroRepository) {
        this.livroRepository = livroRepository;
        this.membroRepository = membroRepository;
    }
    public static EmprestimoDto convertEntityToDto(EmprestimoEntity entity) {
        EmprestimoDto emprestimoDto = new EmprestimoDto(entity);
        BeanUtils.copyProperties(entity,emprestimoDto);

        return emprestimoDto;
    }
    public static List<EmprestimoDto> convertEntityToDto(List<EmprestimoEntity> emprestimoEntityList) {
        List<EmprestimoDto> emprestimosDto = new ArrayList<>();
        for (EmprestimoEntity item : emprestimoEntityList) {
            emprestimosDto.add((EmprestimoDto) convertEntityToDto(item));
        }
        return emprestimosDto;
    }
    public static EmprestimoEntity convertDtoToEntity(EmprestimoDto emprestimo,
                                                      MembroEntity membro,
                                                      LivroEntity livro) {
        EmprestimoEntity emprestimoEntity = new EmprestimoEntity();
        BeanUtils.copyProperties(emprestimo,emprestimoEntity);
        emprestimoEntity.setMembro(membro);
        emprestimoEntity.setLivro(livro);
        return emprestimoEntity;
    }
    public static List<EmprestimoEntity> convertDtoToEntity(List<EmprestimoDto> emprestimosDto,
                                                            MembroEntity membro,
                                                            LivroEntity livro) {
        List<EmprestimoEntity> emprestimosEntity = new ArrayList<>();
        for (EmprestimoDto item : emprestimosDto) {
            emprestimosEntity.add(convertDtoToEntity(item,membro,livro));
        }
        return emprestimosEntity;
    }
}
