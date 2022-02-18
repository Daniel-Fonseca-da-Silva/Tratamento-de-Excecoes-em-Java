public class PassouLimiteArrayException extends Exception{
    private int numerador;
    private int denominador;

    public PassouLimiteArrayException(String message, int numerador, int denominador) {
        super(message);
        this.numerador = numerador;
        this.denominador = denominador;
    }
}
