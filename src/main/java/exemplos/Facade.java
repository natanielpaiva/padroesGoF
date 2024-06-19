package exemplos;

// Subsistema de áudio
class SistemaAudio {
    void configurarAudio() {
        System.out.println("Configurando áudio");
    }

    void reproduzirAudio() {
        System.out.println("Reproduzindo áudio");
    }
}

// Subsistema de vídeo
class SistemaVideo {
    void configurarVideo() {
        System.out.println("Configurando vídeo");
    }

    void reproduzirVideo() {
        System.out.println("Reproduzindo vídeo");
    }
}

// Subsistema de imagem
class SistemaImagem {
    void configurarImagem() {
        System.out.println("Configurando imagem");
    }

    void exibirImagem() {
        System.out.println("Exibindo imagem");
    }
}

// Fachada para simplificar a interação com os subsistemas de mídia
class FacadeMidia {
    private SistemaAudio audio;
    private SistemaVideo video;
    private SistemaImagem imagem;

    public FacadeMidia() {
        this.audio = new SistemaAudio();
        this.video = new SistemaVideo();
        this.imagem = new SistemaImagem();
    }

    void reproduzirMidia() {
        audio.configurarAudio();
        video.configurarVideo();
        imagem.configurarImagem();
        audio.reproduzirAudio();
        video.reproduzirVideo();
        imagem.exibirImagem();
    }
}

// Uso da fachada
public class Facade {
    public static void main(String[] args) {
        FacadeMidia fachadaMidia = new FacadeMidia();
        fachadaMidia.reproduzirMidia();
    }
}