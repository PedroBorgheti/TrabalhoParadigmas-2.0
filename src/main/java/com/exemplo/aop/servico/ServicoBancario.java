package com.exemplo.aop.servico;

import org.springframework.stereotype.Service;

@Service
public class ServicoBancario {
    
    public void transferir(double valor, String contaOrigem, String contaDestino) {
        // APENAS L?GICA DE NEG?CIO - SEM LOGGING!
        try {
            // Simula valida??o
            Thread.sleep(1000);
            
            // Simula processamento
            Thread.sleep(1000);
            
            // Simula sucesso
            System.out.println("?? Transfer?ncia REALIZADA!");
            
        } catch (Exception e) {
            throw new RuntimeException("Falha na transfer?ncia", e);
        }
    }
    
    public void consultarSaldo(String numeroConta) {
        // APENAS L?GICA DE NEG?CIO - SEM LOGGING!
        try {
            Thread.sleep(800);
            double saldo = Math.random() * 10000;
            System.out.println("?? Saldo atual: R$ " + String.format("%.2f", saldo));
            
        } catch (Exception e) {
            throw new RuntimeException("Falha na consulta", e);
        }
    }
    
    // M?TODO QUE VAI FALHAR (para demonstrar tratamento de erro)
    public void metodoComErro() {
        throw new RuntimeException("Erro simulado para demonstra??o!");
    }
}
