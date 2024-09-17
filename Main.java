public class Main {
    public static void main(String[] args) {
        LeituraArvore la = new LeituraArvore();
        ManipulaMatriz mr = new ManipulaMatriz();
        char[][] matrizArvore = la.lerArquivo("casof1.txt");
        for (int i = 0; i < matrizArvore.length; i++) {
            System.out.println(matrizArvore[i]);
    }
        System.out.println(mr.percorrerArvore());
  }
}
