package steps;

import org.example.Calculadora; // <--- Import da classe Calculadora do pacote org.example
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import static org.junit.Assert.assertEquals;

public class CalculadoraSteps {

    private int num1;
    private int num2;
    private int resultado;
    private Exception exception;

    // Captura os dois números informados no cenário da feature
    @Dado("que eu tenho os números {int} e {int}")
    public void queEuTenhoOsNumeros(int a, int b) {
        this.num1 = a;
        this.num2 = b;
    }

    // Executa a operação de soma usando a classe Calculadora
    @Quando("eu peço para somar")
    public void euPecoParaSomar() {
        this.resultado = Calculadora.somar(num1, num2);
    }

    // Executa a operação de divisão tratando exceções (ex: divisão por zero)
    @Quando("eu peço para dividir")
    public void euPecoParaDividir() {
        try {
            this.resultado = Calculadora.dividir(num1, num2);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    // Valida se o resultado numérico é o esperado
    @Então("o resultado deve ser {int}")
    public void oResultadoDeveSer(int resultadoEsperado) {
        assertEquals(resultadoEsperado, this.resultado);
    }

    // Valida a mensagem da exceção lançada
    @Então("o sistema deve informar {string}")
    public void oSistemaDeveInformar(String mensagemEsperada) {
        assertEquals(mensagemEsperada, this.exception.getMessage());
    }
}

