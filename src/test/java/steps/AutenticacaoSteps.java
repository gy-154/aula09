package steps;

import org.example.SistemaAutenticacao;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AutenticacaoSteps {

    private boolean resultadoLogin;

    // Regista o utilizador no sistema para preparar o teste
    @Dado("que o usuário {string} com senha {string} está cadastrado")
    public void queOUsuarioComSenhaEstaCadastrado(String usuario, String senha) {
        SistemaAutenticacao.cadastrarUtilizador(usuario, senha);
    }

    // Executa a tentativa de login
    @Quando("eu faço login com {string} e {string}")
    public void euFacoLoginComE(String usuario, String senha) {
        this.resultadoLogin = SistemaAutenticacao.fazerLogin(usuario, senha);
    }

    // Valida que o acesso foi permitido
    @Então("acesso é concedido")
    public void acessoEConcedido() {
        assertTrue("O acesso deveria ter sido concedido", this.resultadoLogin);
    }

    // Valida que o acesso foi bloqueado
    @Então("o acesso é negado")
    public void oAcessoENegado() {
        assertFalse("O acesso deveria ter sido negado", this.resultadoLogin);
    }
}
