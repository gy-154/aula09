package org.example;

import java.util.regex.Pattern;

public class NotificacaoService {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    public boolean enviarEmail(String email, String mensagem) {
        if (email == null || !PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Formato de e-mail inválido");
        }
        System.out.println("Enviando mensagem para " + email + ": " + mensagem);
        return true;
    }
}