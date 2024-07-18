
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }


    @Override
    public void calcularJuros() {
        double taxaJuros = 0.005;
        double juros = this.getSaldo() * taxaJuros;
        this.depositar(juros);
        System.out.printf("Juros de %.2f adicionados ao saldo%n", juros);
    }
}

