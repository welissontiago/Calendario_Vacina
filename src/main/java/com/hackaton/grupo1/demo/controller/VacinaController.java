package com.hackaton.grupo1.demo.controller;

import com.hackaton.grupo1.demo.controller.docs.VacinaControllerDocs;
import com.hackaton.grupo1.demo.dto.VacinaDTO;
import com.hackaton.grupo1.demo.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacinas")
public class VacinaController implements VacinaControllerDocs {

    @Autowired
    private VacinaService vacinaService;

    @GetMapping("/consultar")
    public ResponseEntity<List<VacinaDTO>> listarTodas() {
        List<VacinaDTO> vacinas = vacinaService.listarTodas();
        return ResponseEntity.ok(vacinas);
    }

    @GetMapping("/consultar/faixa_etaria/{faixa}")
    public ResponseEntity<List<VacinaDTO>> listarPorFaixaEtaria(@PathVariable String faixa) {
        try {
            List<VacinaDTO> vacinas = vacinaService.listarPorFaixaEtaria(faixa);
            return ResponseEntity.ok(vacinas);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Faixa etária inválida. Use: CRIANÇA, ADOLESCENTE, ADULTO ou GESTANTE.");
        }
    }

    @GetMapping("/consultar/idade_maior/{meses}")
    public ResponseEntity<List<VacinaDTO>> listarPorIdadeMaior(@PathVariable int meses) {
        List<VacinaDTO> vacinas = vacinaService.listarPorIdadeMaior(meses);
        return ResponseEntity.ok(vacinas);
    }
}
