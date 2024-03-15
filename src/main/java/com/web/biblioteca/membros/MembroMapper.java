package com.web.biblioteca.membros;

import java.util.ArrayList;
import java.util.List;

public class MembroMapper {
    public static MembroDto convertMembroEntityToDto(MembroEntity membroEntity) {
        MembroDto membroDto = new MembroDto();
        membroDto.setNomeCompleto(membroEntity.getNomeCompleto());
        membroDto.setEndereco(membroEntity.getEndereco());
        membroDto.setNacionalidade(membroEntity.getNacionalidade());
        membroDto.setTelefone(membroEntity.getTelefone());
        membroDto.setEmail(membroEntity.getEmail());
        membroDto.setDataNascimento(membroEntity.getDataNascimento());
        membroDto.setAlugou(membroEntity.getAlugou());
        return membroDto;
    }
    public static Iterable<MembroDto> convertMembroEntityToDto(Iterable<MembroEntity> membrosEntity) {
        List<MembroDto> membrosDto = new ArrayList<>();
        for (MembroEntity membroEntity : membrosEntity) {
            membrosDto.add(convertMembroEntityToDto(membroEntity));
        }
        return membrosDto;
    }
    public static MembroEntity convertMembroDtoToEntity(MembroDto membroDto) {
        MembroEntity membroEntity = new MembroEntity();
        membroEntity.setNomeCompleto(membroDto.getNomeCompleto());
        membroEntity.setEndereco(membroDto.getEndereco());
        membroEntity.setNacionalidade(membroDto.getNacionalidade());
        membroEntity.setEmail(membroDto.getEmail());
        membroEntity.setTelefone(membroDto.getTelefone());
        membroEntity.setDataNascimento(membroDto.getDataNascimento());
        membroEntity.setAlugou(membroDto.getAlugou());
        return membroEntity;
    }
    public static List<MembroEntity> convertMembroDtoToEntity(List<MembroDto> membrosDto) {
        List<MembroEntity> membrosEntity = new ArrayList<>();
        for (MembroDto membroDto : membrosDto) {
            membrosEntity.add(convertMembroDtoToEntity(membroDto));
        }
        return membrosEntity;
    }
}
