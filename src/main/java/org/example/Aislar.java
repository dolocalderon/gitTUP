package org.example;

public class Aislar {
    private Integer numeroKit;
    private float temperatura;
    private String barrio;

    public Aislar() {
    }

    public Aislar(Integer numeroKit, float temperatura, String barrio) {
        this.numeroKit = numeroKit;
        this.temperatura = temperatura;
        this.barrio = barrio;
    }

    public Integer getNumeroKit() {
        return numeroKit;
    }

    public void setNumeroKit(Integer numeroKit) {
        this.numeroKit = numeroKit;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @Override
    public String toString() {
        return "Aislar{" +
                "numeroKit=" + numeroKit +
                ", temperatura=" + temperatura +
                ", barrio='" + barrio + '\'' +
                '}';
    }
}
