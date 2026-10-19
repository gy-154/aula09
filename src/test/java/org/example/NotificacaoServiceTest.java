package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificacaoServiceTest {

    private final NotificacaoService notificacaoService = new NotificacaoService();

    @Test
    public void deveEnviarEmailQuandoEmailForValido() {
        boolean resultado = notificacaoService.enviarEmail("usuario@exemplo.com", "Olá, mundo!");
        assertTrue(resultado);
    }

    @Test
    public void deveLancarExcecaoQuandoEmailForInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            notificacaoService.enviarEmail("email-invalido", "Teste");
        });
    }
}