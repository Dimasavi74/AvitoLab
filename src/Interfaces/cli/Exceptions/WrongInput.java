package Interfaces.cli.Exceptions;

public class WrongInput extends RuntimeException {
    public WrongInput(String message) {
        super(message);
    }
}
