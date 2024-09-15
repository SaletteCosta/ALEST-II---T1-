import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArvore {
    public static char[][] lerArquivo(String nomeArquivo) {
        char[][] matrizInicial = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String primeiraLinha = reader.readLine();
            String[] dimensao = primeiraLinha.split(" ");
            int numLinhas = Integer.parseInt(dimensao[0]);
            int numColunas = Integer.parseInt(dimensao[1]);
            matrizInicial = new char[numLinhas][numColunas];
            for (int i = 0; i < numLinhas; i++) {
                String linha = reader.readLine();
                if (linha != null) {
                    matrizInicial[i] = linha.toCharArray();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
        return matrizInicial;
    }
}

