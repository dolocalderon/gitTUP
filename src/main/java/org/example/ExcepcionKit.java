package org.example;

public class ExcepcionKit extends Exception{
    public ExcepcionKit() {
        super("No hay reactivos disponibles");
    }

    public ExcepcionKit(String message) {
        super(message);
    }


}
