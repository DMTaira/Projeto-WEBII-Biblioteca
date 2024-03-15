package com.web.biblioteca.livros;

import java.util.ArrayList;
import java.util.List;

public class LivroMapper {
    public static LivroDto convertLivroEntityToDto(LivroEntity LivroEntity) {
        LivroDto LivroDto = new LivroDto();
        LivroDto.setTitulo(LivroEntity.getTitulo());
        LivroDto.setAutor(LivroEntity.getAutor());
        LivroDto.setGenero(LivroEntity.getGenero());
        LivroDto.setIsbn(LivroEntity.getIsbn());
        LivroDto.setQuantidade(LivroEntity.getQuantidade());
        LivroDto.setAnoLancamento(LivroEntity.getAnoLancamento());
        return LivroDto;
    }
    public static Iterable<LivroDto> convertLivroEntityToDto(Iterable<LivroEntity> LivrosEntity) {
        List<LivroDto> LivrosDto = new ArrayList<>();
        for (LivroEntity LivroEntity : LivrosEntity) {
            LivrosDto.add(convertLivroEntityToDto(LivroEntity));
        }
        return LivrosDto;
    }
    public static LivroEntity convertLivroDtoToEntity(LivroDto LivroDto) {
        LivroEntity LivroEntity = new LivroEntity();
        LivroEntity.setTitulo(LivroDto.getTitulo());
        LivroEntity.setGenero(LivroDto.getGenero());
        LivroEntity.setAnoLancamento(LivroDto.getAnoLancamento());
        LivroEntity.setIsbn(LivroDto.getIsbn());
        LivroEntity.setQuantidade(LivroDto.getQuantidade());
        return LivroEntity;
    }
    public static List<LivroEntity> convertLivroDtoToEntity(List<LivroDto> LivrosDto) {
        List<LivroEntity> LivrosEntity = new ArrayList<>();
        for (LivroDto LivroDto : LivrosDto) {
            LivrosEntity.add(convertLivroDtoToEntity(LivroDto));
        }
        return LivrosEntity;
    }
}
