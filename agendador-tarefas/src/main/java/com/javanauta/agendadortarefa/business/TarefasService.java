package com.javanauta.agendadortarefa.business;

import com.javanauta.agendadortarefa.business.dto.TarefasDTO;
import com.javanauta.agendadortarefa.business.mapper.TarefasConverter;
import com.javanauta.agendadortarefa.infrastructure.entity.TarefasEntity;
import com.javanauta.agendadortarefa.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.agendadortarefa.infrastructure.repository.TarefasRepository;
import com.javanauta.agendadortarefa.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
    @RequiredArgsConstructor
    public class TarefasService {

        private final TarefasRepository tarefasRepository;
        private final TarefasConverter tarefasConverter;
        private final JwtUtil jwtUtil;

        public TarefasDTO gravarTarefa (String token, TarefasDTO dto){
            String email = jwtUtil.extrairEmailToken(token.substring(7));
            dto.setDataCriacao(LocalDateTime.now());
            dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
            dto.setEmailUsuario(email);
            TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

            return tarefasConverter.paraTarefaDTO(
                    tarefasRepository.save(entity));
        }

        public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal){

            return tarefasConverter.paraListaTarefasDTO(
                    tarefasRepository.findBydataEventoBetween(dataInicial, dataFinal));

        }

        public List<TarefasDTO> buscaTarefasPorEmail(String token){
            String email = jwtUtil.extrairEmailToken(token.substring(7));
            List<TarefasEntity> listaTarefas = tarefasRepository.findByEmailUsuario(email);

            return tarefasConverter.paraListaTarefasDTO(listaTarefas);

        }


}
