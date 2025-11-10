package com.exemplo.aop.servico;

import org.springframework.stereotype.Service;

@Service
public class ServicoBancarioSemAOP {
    
    public void transferir(double valor, String contaOrigem, String contaDestino) {
        // C?DIGO REPETITIVO - LOGGING MANUAL
        System.out.println("=== LOG: Iniciando transfer?ncia ===");
        System.out.println("DE: " + contaOrigem);
        System.out.println("PARA: " + contaDestino);
        System.out.println("VALOR: R$ " + valor);
        
        // L?GICA DE NEG?CIO
        try {
            System.out.println("? Validando saldo...");
            Thread.sleep(1000);
            
            System.out.println("? Processando transfer?ncia...");
            Thread.sleep(1000);
            
            System.out.println("?? Transfer?ncia conclu?da com sucesso!");
            
        } catch (Exception e) {
            System.out.println("? ERRO na transfer?ncia: " + e.getMessage());
        }
        
        // MAIS C?DIGO REPETITIVO
        System.out.println("=== LOG: Fim da transfer?ncia ===\n");
    }
    
    public void consultarSaldo(String numeroConta) {
        // MESMO PROBLEMA - LOGGING REPETITIVO
        System.out.println("=== LOG: Consultando saldo ===");
        System.out.println("CONTA: " + numeroConta);
        
        try {
            System.out.println("?? Buscando saldo...");
            Thread.sleep(800);
            double saldo = Math.random() * 10000;
            System.out.println("?? Saldo: R$ " + String.format("%.2f", saldo));
            
        } catch (Exception e) {
            System.out.println("? ERRO na consulta: " + e.getMessage());
        }
        
        System.out.println("=== LOG: Fim da consulta ===\n");
    }
}
