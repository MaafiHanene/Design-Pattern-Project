package Exceptions;

public class NonCompatible extends Exception {

    public String getMessage() {
        return "L'animal est incompatible avec l'enclos ! ";
    }
}
