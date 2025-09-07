package com.lasmarj.imc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lasmarj.imc.dto.ImcRequest;
import com.lasmarj.imc.dto.ImcResponse;
import com.lasmarj.imc.service.ImcService;

@RestController
@RequestMapping("/api/imc")
public class ImcController {

    private final ImcService imcService;

    public ImcController(ImcService imcService) {
        this.imcService = imcService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<ImcResponse> calcularImc(@RequestBody ImcRequest request) {
        return ResponseEntity.ok(imcService.calcularImc(request));
    }

    @GetMapping("/ultimo-resultado")
    public ResponseEntity<ImcResponse> obterUltimoResultado() {
        ImcResponse ultimoResultado = imcService.obterUltimoResultado();
        if (ultimoResultado == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(imcService.obterUltimoResultado());
    }


}
