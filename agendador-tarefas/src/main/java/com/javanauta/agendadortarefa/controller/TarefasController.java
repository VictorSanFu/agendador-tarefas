package com.javanauta.agendadortarefa.controller;

import com.javanauta.agendadortarefa.business.TarefasService;
import com.javanauta.agendadortarefa.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.osgi.annotation.bundle.Requirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestHeader("Authorization") String token){
       return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }

}
