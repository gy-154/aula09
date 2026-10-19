package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável por gerir o cadastro e a autenticação dos utilizadores.
 */
public class SistemaAutenticacao {

    // Base de dados simulada para guardar os utilizadores e senhas
    private static final Map<String, String> utilizadoresCadastrados = new HashMap<>();

    // Regista um novo utilizador na memória
    public static void cadastrarUtilizador(String utilizador, String senha) {
        utilizadoresCadastrados.put(utilizador, senha);
    }

    // Validação de senha implementada

    // Valida as credenciais prestadas
    public static boolean fazerLogin(String utilizador, String senha) {
        if (!utilizadoresCadastrados.containsKey(utilizador)) {
            return false;
        }
        return utilizadoresCadastrados.get(utilizador).equals(senha);
    }
}
