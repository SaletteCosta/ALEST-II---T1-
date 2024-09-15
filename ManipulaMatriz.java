public class ManipulaMatriz {
    private char matriz [][];

    private void pegarMatriz(){
        matriz = LeituraArvore.lerArquivo("casof30");
    }

    private int encontrarMaiorCaminho(){
        return 0;
    }
    public void percorrerArvore(){

    }


    // iremos trabalhar com manipulação de indices da matriz ex: o filho a esquerda esta uma linha acima e uma coluna a frente
    // ou seja se o pai esta na linha 23 coluna 20, o filho esta na linha 22 coluna 19
    //o filho a direita dp pai na linha 23, cpluna 20 esta na linha 22 coluna 21
    // quando houver cruzamento, sobe a linha e verifica o char a esquerda pu dieita para ver s ha um outro traço, numero ou nodo folha
}
