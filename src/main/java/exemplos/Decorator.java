package exemplos;

// Interface do botão
interface Botao {
    void desenhar();
}

// Implementação do botão básico
class BotaoBasico implements Botao {
    @Override
    public void desenhar() {
        System.out.println("Desenhando botão básico");
    }
}

// Decorador para adicionar ícone ao botão
class BotaoComIcone implements Botao {
    private Botao botao;

    public BotaoComIcone(Botao botao) {
        this.botao = botao;
    }

    @Override
    public void desenhar() {
        botao.desenhar();
        System.out.println("Adicionando ícone ao botão");
    }
}

// Decorador para mudar a cor do botão
class BotaoComCor implements Botao {
    private Botao botao;

    public BotaoComCor(Botao botao) {
        this.botao = botao;
    }

    @Override
    public void desenhar() {
        botao.desenhar();
        System.out.println("Mudando a cor do botão");
    }
}

// Uso dos decoradores
public class Decorator {
    public static void main(String[] args) {
        Botao botaoBasico = new BotaoBasico();
        Botao botaoComIcone = new BotaoComIcone(botaoBasico);
        Botao botaoComCor = new BotaoComCor(botaoComIcone);
        botaoComCor.desenhar();
    }
}