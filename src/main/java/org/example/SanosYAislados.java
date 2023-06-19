package org.example;

import java.util.ArrayList;
import java.util.List;

public class SanosYAislados {
    private List<Persona> listaSanos;
    private List<Aislar> listaAislar;


    public SanosYAislados() {
        listaSanos = new ArrayList<>();
        listaAislar = new ArrayList<>();
    }


    public void addSanos(Persona p){
        listaSanos.add(p);
    }


    public void addAislados(Persona p, float temperatura){
        Aislar a = new Aislar(p.getNumeroKit(), temperatura, p.getBarrio());
        listaAislar.add(a);
    }


    public SanosYAislados(List<Persona> listaSanos, List<Aislar> listaAislar) {
        this.listaSanos = listaSanos;
        this.listaAislar = listaAislar;
    }

    public List<Persona> getListaSanos() {
        return listaSanos;
    }

    public void setListaSanos(List<Persona> listaSanos) {
        this.listaSanos = listaSanos;
    }

    public List<Aislar> getListaAislar() {
        return listaAislar;
    }

    public void setListaAislar(List<Aislar> listaAislar) {
        this.listaAislar = listaAislar;
    }

    @Override
    public String toString() {
        return "SanosYAislados{" +
                "listaSanos=" + listaSanos +
                ", listaAislar=" + listaAislar +
                '}';
    }
}
