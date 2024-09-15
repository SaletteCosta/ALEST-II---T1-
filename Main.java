public class Main {
    public static void main(String[] args) {
        LeituraArvore la = new LeituraArvore();
        char[][] matrizArvore = la.lerArquivo("casof30.txt");
        for (int i = 0; i < matrizArvore.length; i++) {
            System.out.println(matrizArvore[i]);
        }
    }
}
