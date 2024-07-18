import lombok.Data;

public class ContaCorrente extends Conta {

    private double limiteChequeEspecial = 1000.00;
    private double taxaJurosChequeEspecial = 0.10;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.getSaldo() + limiteChequeEspecial) {
            if (valor > this.getSaldo()) {
                double valorChequeEspecialUtilizado = valor - this.getSaldo();
                double juros = valorChequeEspecialUtilizado * taxaJurosChequeEspecial;
                this.setSaldo(this.getSaldo() - valor - juros); // Desconta o valor sacado e os juros do saldo
                System.out.printf("Saque de R$%.2f realizado com sucesso. Juros de cheque especial: R$%.2f.\n", valor, juros);
            } else {
                this.setSaldo(this.getSaldo() - valor);
                System.out.printf("Saque de R$%.2f realizado com sucesso.\n", valor);
            }
        } else {
            System.out.println("Saque não realizado. Valor solicitado excede o limite do cheque especial.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void calcularJuros() {
        // Implementar cálculo de juros para conta corrente, se necessário
    }
}
