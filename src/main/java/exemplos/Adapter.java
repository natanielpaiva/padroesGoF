package exemplos;

// Interface esperada pelo sistema
interface Pagamento {
    void pagar(double valor);
}

// Implementação da nova API de pagamento
class PagamentoAPI {
    void realizarPagamento(double valor) {
        System.out.println("Pagamento de " + valor + " realizado com a nova API.");
    }
}

// Adaptador que converte a interface da nova API para a interface esperada
class PagamentoAdapter implements Pagamento {
    private PagamentoAPI pagamentoAPI;

    public PagamentoAdapter(PagamentoAPI pagamentoAPI) {
        this.pagamentoAPI = pagamentoAPI;
    }

    @Override
    public void pagar(double valor) {
        pagamentoAPI.realizarPagamento(valor);
    }
}

// Uso do adaptador
public class Adapter {
    public static void main(String[] args) {
        PagamentoAPI apiNova = new PagamentoAPI();
        Pagamento adaptador = new PagamentoAdapter(apiNova);
        adaptador.pagar(100.0);
    }
}