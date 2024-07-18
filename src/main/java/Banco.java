import java.util.List;
import lombok.*;

@Data
public class Banco {

	private String nome;
	private List<Conta> contas;



	public void listarContas() {
    System.out.println("Listagem de contas do banco " + this.nome + ":");
    for (Conta conta : contas) {
        System.out.println("voce possui as seguintes contas: "+conta.getCliente().getNome());
    }
}


}
