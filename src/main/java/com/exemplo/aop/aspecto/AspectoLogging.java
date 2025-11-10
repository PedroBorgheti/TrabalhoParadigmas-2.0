package com.exemplo.aop.aspecto;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class AspectoLogging {

    // POINTCUT do AspectJ: Todos os m?todos do ServicoBancario
    @Pointcut("execution(* com.exemplo.aop.servico.ServicoBancario.*(..))")
    public void metodosDoServicoBancario() {}

    // AROUND: Controle total sobre a execu??o (substitui todos os outros)
    @Around("metodosDoServicoBancario()")
    public Object logCompleto(ProceedingJoinPoint joinPoint) throws Throwable {
        String metodoNome = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        
        System.out.println("=== ?? ASPECTJ: Iniciando " + metodoNome + " ===");
        System.out.println("?? Argumentos: " + Arrays.toString(args));
        
        long inicio = System.currentTimeMillis();
        
        try {
            Object resultado = joinPoint.proceed(); // Executa o m?todo original
            
            long fim = System.currentTimeMillis();
            System.out.println("? " + metodoNome + " executado com SUCESSO");
            System.out.println("?? Tempo de execu??o: " + (fim - inicio) + "ms");
            System.out.println("=== ?? ASPECTJ: Finalizado " + metodoNome + " ===\n");
            
            return resultado;
            
        } catch (Exception e) {
            long fim = System.currentTimeMillis();
            System.out.println("? ERRO em " + metodoNome + ": " + e.getMessage());
            System.out.println("?? Tempo at? erro: " + (fim - inicio) + "ms");
            System.out.println("=== ?? ASPECTJ: Finalizado " + metodoNome + " ===\n");
            throw e;
        }
    }
}
