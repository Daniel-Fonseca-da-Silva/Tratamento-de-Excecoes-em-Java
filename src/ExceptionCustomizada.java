import javax.swing.*;
import java.io.*;

public class ExceptionCustomizada {

    //Imprimir um arquivo no console.
        public static void main(String[] args)  {
            String nomeDoArquivo = JOptionPane.showInputDialog("Insira o nome do arquivo para iniciar a busca");
            imprimirArquivoNoConsole(nomeDoArquivo);

            System.out.println("Apesar da exception ou não, o programa continua...");
        }

        public static void imprimirArquivoNoConsole(String nomeDoArquivo) {
            try{
            BufferedReader br = lerArquivo(nomeDoArquivo);
            String line = br.readLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            do {
                bw.write(line);
                bw.newLine();
                line=br.readLine();
            }while(line != null);
            bw.flush();
            br.close();
            }
            catch (ImpossivelAberturaDoArquivoException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,": " + e.getMessage());
            }
            catch(IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        public static BufferedReader lerArquivo(String nomeDoArquivo) throws ImpossivelAberturaDoArquivoException {
            File file = new File(nomeDoArquivo);
            try {
                return new BufferedReader(new FileReader(nomeDoArquivo));
            } catch (FileNotFoundException e) {
                throw new ImpossivelAberturaDoArquivoException(file.getName(), file.getPath());
            }
        }
    }
class ImpossivelAberturaDoArquivoException extends Exception{

    private String nomeArquivo;
    private String diretorio;

    public ImpossivelAberturaDoArquivoException(String nomeArquivo, String diretorio) {
        super("O arquivo " + nomeArquivo + " não foi encontrado no diretorio " + diretorio);
        this.nomeArquivo = nomeArquivo;
        this.diretorio = diretorio;
    }

    @Override
    public String toString() {
        return "Impossivel a abertura do arquivo {" +
                "nome do arquivo:'" + nomeArquivo + '\'' +
                ", diretorio:'" + diretorio + '\'' +
                '}';
    }
}