package com.lasmarj.imc.storage;

import org.springframework.stereotype.Component;

import com.lasmarj.imc.dto.ImcResponse;

@Component
public class LastResultStorage {

    private ImcResponse lastResult;

    public void salvarResultado(ImcResponse lastResult) {
        this.lastResult = lastResult;
    }

    public ImcResponse obeterultimoResultado() {
        return lastResult;
    }
}
