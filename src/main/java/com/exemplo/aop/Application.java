package com.exemplo.aop;

import com.exemplo.aop.servico.ServicoBancario;
import com.exemplo.aop.servico.ServicoBancarioSemAOP;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ServicoBancario servicoComAOP, 
                                 ServicoBancarioSemAOP servicoSemAOP) {
        return args -> {
            System.out.println("?? INICIANDO DEMONSTRA??O AOP ??\n");
            
            // DEMONSTRA??O SEM AOP
            System.out.println("========== ?? SEM AOP ==========");
            servicoSemAOP.transferir(1500.0, "12345-6", "78901-2");
            servicoSemAOP.consultarSaldo("12345-6");
            
            Thread.sleep(2000);
            
            // DEMONSTRA??O COM AOP
            System.out.println("========== ?? COM AOP ==========");
            servicoComAOP.transferir(2500.0, "33333-6", "44444-2");
            servicoComAOP.consultarSaldo("33333-6");
            
            Thread.sleep(1000);
            
            // DEMONSTRA??O DE TRATAMENTO DE ERRO COM AOP
            System.out.println("========== ?? AOP COM ERRO ==========");
            try {
                servicoComAOP.metodoComErro();  // CORRIGIDO: metetoComErro ? metodoComErro
            } catch (Exception e) {
                System.out.println("?? Erro capturado, mas o logging j? foi feito pelo Aspecto!");
            }
            
            System.out.println("\n?? DEMONSTRA??O CONCLU?DA!");
            System.out.println("?? Observa??o: Com AOP, o c?digo de neg?cio fica LIMPO!");
            System.out.println("?? O logging ? aplicado AUTOMATICAMENTE em todos os m?todos!");
        };
    }
}
