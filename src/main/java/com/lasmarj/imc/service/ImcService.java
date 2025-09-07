package com.lasmarj.imc.service;

import org.springframework.stereotype.Service;

import com.lasmarj.imc.dto.ImcRequest;
import com.lasmarj.imc.dto.ImcResponse;
import com.lasmarj.imc.storage.LastResultStorage;
import com.lasmarj.imc.util.ImcCalculator;

@Service
public class ImcService {

    private final LastResultStorage lastResultStorage;

    public ImcService(LastResultStorage lastResultStorage) {
        this.lastResultStorage = lastResultStorage;
    }

    public ImcResponse calcularImc(ImcRequest request){
        double alturaCm = ImcCalculator.calcularAltura(request.altura());
        double pesoIdeal = ImcCalculator.calcularPeso(alturaCm, request.peso());
        double imc = ImcCalculator.calcularImc(alturaCm, request.peso());
        String interpretacao = ImcCalculator.classificarImc(imc);
        
        ImcResponse response = new ImcResponse(imc, interpretacao, pesoIdeal, alturaCm);
        lastResultStorage.salvarResultado(response);
        return response;
    }

    public ImcResponse obterUltimoResultado() {
        return lastResultStorage.obeterultimoResultado();
    }
}
