import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManipulaMatriz {
    private char[][] matriz;
    private Set<String> visitados;

    public ManipulaMatriz() {
        pegarMatriz();
        visitados = new HashSet<>();
    }

    private void pegarMatriz() {
        matriz = LeituraArvore.lerArquivo("casof1.txt");
    }

    public List<String> percorrerArvore() {
        List<String> caminhos = new ArrayList<>();
        char valorRaiz = acharValorRaiz();
        if (valorRaiz == ' ') {
            System.out.println("Raiz não encontrada.");
            return caminhos;
        }

        int[] posicaoRaiz = acharIndiceRaiz();
        switch (valorRaiz) {
            case 'V':
                System.out.println("Raiz é um V (bifurcação).");
                percorrerBifurcacao(posicaoRaiz, caminhos);
                break;
            case 'W':
                System.out.println("Raiz é um W (trifurcação).");
                percorrerTrifurcacao(posicaoRaiz, caminhos);
                break;
            case '#':
                System.out.println("Raiz é um #");
                caminhos.add("Raiz é um #");
                break;
            case '|':
                System.out.println("A raiz é um |");
                percorrerVertical(posicaoRaiz, caminhos);
                break;
            case '\\':
                System.out.println("A raiz é um \\");
                percorrerEsquerda(posicaoRaiz, caminhos);
                break;
            case '/':
                System.out.println("A raiz é um /");
                percorrerDireita(posicaoRaiz, caminhos);
                break;
            default:
                System.out.println("Tipo de raiz desconhecido.");
                break;
        }

        return caminhos;
    }

    public void percorrerBifurcacao(int[] posicaoRaiz, List<String> caminhos) {
        percorrerDireita(posicaoRaiz, caminhos);
        percorrerEsquerda(posicaoRaiz, caminhos);
    }

    public void percorrerTrifurcacao(int[] posicaoRaiz, List<String> caminhos) {
        percorrerEsquerda(posicaoRaiz, caminhos);
        percorrerVertical(posicaoRaiz, caminhos);
        percorrerDireita(posicaoRaiz, caminhos);
    }

    public void percorrerVertical(int[] posicaoRaiz, List<String> caminhos) {
        int linha = posicaoRaiz[0];
        int coluna = posicaoRaiz[1];

        StringBuilder caminhoAtual = new StringBuilder();

        while (linha >= 0) {
            char valorAtual = matriz[linha][coluna];
            caminhoAtual.append(valorAtual);

            if (valorAtual == '#') {
                caminhos.add(caminhoAtual.toString());
                System.out.println("Percurso vertical finalizado no traço (#).");
                return;
            }

            if (valorAtual == 'V') {
                percorrerBifurcacao(new int[]{linha - 1, coluna}, caminhos);
                return;
            }

            if (valorAtual == 'W') {
                percorrerTrifurcacao(new int[]{linha - 1, coluna}, caminhos);
                return;
            }

            linha--;
            if (linha < 0) break;
        }

        caminhos.add(caminhoAtual.toString());
    }

    public void percorrerEsquerda(int[] posicaoRaiz, List<String> caminhos) {
        int linha = posicaoRaiz[0];
        int coluna = posicaoRaiz[1];

        StringBuilder caminhoAtual = new StringBuilder();

        while (linha >= 0 && coluna >= 0) {
            char valorAtual = matriz[linha][coluna];
            caminhoAtual.append(valorAtual);

            if (valorAtual == '#') {
                caminhos.add(caminhoAtual.toString());
                System.out.println("Percurso à esquerda finalizado no traço (#).");
                return;
            }

            if (valorAtual == 'V') {
                percorrerBifurcacao(new int[]{linha - 1, coluna - 1}, caminhos);
                return;
            }

            if (valorAtual == 'W') {
                percorrerTrifurcacao(new int[]{linha - 1, coluna - 1}, caminhos);
                return;
            }

            linha--;
            coluna--;
            if (linha < 0 || coluna < 0) break;
        }

        caminhos.add(caminhoAtual.toString());
    }

    public void percorrerDireita(int[] posicaoRaiz, List<String> caminhos) {
        int linha = posicaoRaiz[0];
        int coluna = posicaoRaiz[1];

        StringBuilder caminhoAtual = new StringBuilder();

        while (linha >= 0 && coluna < matriz[0].length) {
            char valorAtual = matriz[linha][coluna];
            caminhoAtual.append(valorAtual);

            if (valorAtual == '#') {
                caminhos.add(caminhoAtual.toString());
                System.out.println("Percurso à direita finalizado no traço (#).");
                return;
            }

            if (valorAtual == 'V') {
                percorrerBifurcacao(new int[]{linha - 1, coluna + 1}, caminhos);
                return;
            }

            if (valorAtual == 'W') {
                percorrerTrifurcacao(new int[]{linha - 1, coluna + 1}, caminhos);
                return;
            }

            linha--;
            coluna++;
            if (linha < 0 || coluna >= matriz[0].length) break;
        }

        caminhos.add(caminhoAtual.toString());
    }

    public int[] acharIndiceRaiz() {
        int ultimaLinha = matriz.length - 1;
        for (int i = 0; i < matriz[ultimaLinha].length; i++) {
            if (matriz[ultimaLinha][i] != ' ') {
                return new int[]{ultimaLinha, i};
            }
        }
        return new int[]{-1, -1};
    }

    public char acharValorRaiz() {
        int[] posicaoRaiz = acharIndiceRaiz();
        int linha = posicaoRaiz[0];
        int coluna = posicaoRaiz[1];
        if (linha == -1 || coluna == -1) {
            return ' ';
        }
        return matriz[linha][coluna];
    }
}

