import javax.swing.*;

//Fazer a divisão de 2 valores inteiros
public class UncheckedException {
    public static void main(String[] args) {

        boolean continueLooping = true;

        do{
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try{
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                continueLooping = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida, verifique: " + e.getMessage());
                e.printStackTrace();
            }
            catch (ArithmeticException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não é possível dividir por zero: " + e.getMessage());
            }
            finally {
                System.out.println("Chamou finally");
            }
        } while(continueLooping);

        System.out.println("Passou do try");
    }

    public static int dividir(int a, int b) {
        return a / b;
    }
}