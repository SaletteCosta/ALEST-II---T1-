public class ManipulaMatriz {
    private char matriz [][];
    public ManipulaMatriz(){
        pegarMatriz();
    }

    private void pegarMatriz(){
        matriz = LeituraArvore.lerArquivo("casof30.txt");
    }

    private int encontrarMaiorCaminho(){
        return 0;
    }

    public int percorrerArvore(int linha, int coluna){
        acharRaiz();
        return linha;
    }

    public char acharRaiz() {
        int ultimaLinha = LeituraArvore.getUltimaLinha();
        for (int i = 0; i < matriz[ultimaLinha].length; i++) {
            if(matriz[ultimaLinha][i] != ' '){
            return matriz[ultimaLinha][i];
        }
    }

    // iremos trabalhar com manipulação de indices da matriz ex: o filho a esquerda esta uma linha acima e uma coluna a frente
    // ou seja se o pai esta na linha 23 coluna 20, o filho esta na linha 22 coluna 19
    //o filho a direita dp pai na linha 23, cpluna 20 esta na linha 22 coluna 21
    // quando houver cruzamento, sobe a linha e verifica o char a esquerda pu dieita para ver s ha um outro traço, numero ou nodo folha

        return 0;
    }
}
