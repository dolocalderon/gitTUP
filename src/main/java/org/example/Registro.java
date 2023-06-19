package org.example;

public class Registro {
    private Integer DNI;
    private float temperatura;


    public Registro() {
    }


    public Registro(Integer DNI, float temperatura) {
        this.DNI = DNI;
        this.temperatura = temperatura;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "DNI=" + DNI +
                ", temperatura=" + temperatura +
                '}';
    }
}
