package com.javanauta.agendadortarefa.business.mapper;

import com.javanauta.agendadortarefa.business.dto.TarefasDTO;
import com.javanauta.agendadortarefa.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);




}
