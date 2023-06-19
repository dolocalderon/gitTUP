package org.example;

public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String barrio;
    private Integer DNI;
    private String profesion;
    private Integer numeroKit;
    private Integer KIT = 0;


    public Persona() {
    }

    public Persona(String nombre, String apellido, Integer edad, String barrio, Integer DNI, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.barrio = barrio;
        this.DNI = DNI;
        this.profesion = profesion;
        numeroKit = ++KIT;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Integer getNumeroKit() {
        return numeroKit;
    }

    public void setNumeroKit(Integer numeroKit) {
        this.numeroKit = numeroKit;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", barrio='" + barrio + '\'' +
                ", DNI=" + DNI +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}
