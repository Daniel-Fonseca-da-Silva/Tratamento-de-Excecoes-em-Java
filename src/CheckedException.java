import javax.swing.*;
import java.io.*;

//Imprimir um arquivo no console.
public class CheckedException {
    public static void main(String[] args) {
        String nomeDoArquivo = "lovecraft.txt";
        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Aconteceu um erro inesperado, contate o suporte: " + e.getCause());
        }
        catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Verifique o nome do arquivo e tente novamente: " + e.getCause());
        }


        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (line != null);
        bw.flush();
        br.close();
    }
}