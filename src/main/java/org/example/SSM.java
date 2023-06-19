package org.example;

import java.util.*;

public class SSM {
    private Integer cantidadReactivos;
    private List<Persona> listaPersonas;
    private Map<Integer, Registro> mapaTesteo;
    private SanosYAislados lista;


    public SSM() {
    }

    public SSM(Integer cantidadReactivos) {
        this.cantidadReactivos = cantidadReactivos;
        listaPersonas = new ArrayList<>();
        mapaTesteo = new HashMap<>();
    }


    public void addPersona(String nombre, String apellido, Integer edad, String barrio, Integer DNI, String profesion) {

        boolean flag = buscarDni(DNI);

        if(!flag) {
            try {
                if(cantidadReactivos > 0)
                {
                    agregarPersona(nombre, apellido, edad, barrio, DNI, profesion);
                }
                else{
                    throw new ExcepcionKit();
                }

            }catch (ExcepcionKit ek) {
                System.out.println("ERROR!");
                boolean respuesta = manejarExcepcionKit();

                if (respuesta) {
                    agregarPersona(nombre, apellido, edad, barrio, DNI, profesion);
                } else{
                    System.out.println("No se pudo agregar la persona ya que no quedan mas kits disponibles");
                }
            }
        } else {
            System.out.println("Ese DNI ya existe en la base de datos");
        }
    }


    public boolean manejarExcepcionKit()
    {
        boolean flag = false;
        Scanner sn = new Scanner(System.in);

        System.out.println("Cuenta con mas test? SI/NO");
        String respuesta = sn.nextLine();

        if(respuesta.equalsIgnoreCase("SI"))
        {
            System.out.println("Ingrese la cantidad de kits que desea ingresar: ");
            Integer cantidad = sn.nextInt();
            setCantidadReactivos(cantidad);
            flag=true;
        }

        return flag;
    }


    public void agregarPersona(String nombre, String apellido, Integer edad, String barrio, Integer DNI, String profesion){
        Persona p = new Persona(nombre, apellido, edad, barrio, DNI, profesion);
        listaPersonas.add(p);
        cantidadReactivos--;
    }


    public boolean buscarDni(Integer DNI)
    {
        boolean flag;

        for (int i=0 ; i<listaPersonas.size() ; i++)
        {
            if(listaPersonas.get(i).getDNI() == DNI)
            {
                return true;
            }
        }
        return false;
    }


    public void testear(){
        Random r = new Random();
        int numKit;


        for(int i=0 ; i<listaPersonas.size() ; i++)
        {
            float temperatura = r.nextFloat(39-36+1) + 36;
            numKit = listaPersonas.get(i).getNumeroKit();
            Registro registro = new Registro(listaPersonas.get(i).getDNI(), temperatura);

            mapaTesteo.put(numKit, registro);
        }
    }


    public void aislar(){

        try {
            for (Map.Entry<Integer, Registro> entry : mapaTesteo.entrySet()) {

                Integer integer_key = entry.getKey();
                Registro registro_value = entry.getValue();

                if(registro_value.getTemperatura() >= 38)
                {
                    throw new Exception("El numero de test es: " + integer_key + " y el barrio es: " + buscarBarrio(integer_key));
                }
            }
        }catch (Exception e){
            e.getMessage();
        }
    }


    public String buscarBarrio(Integer numeroKit){

        for (Persona p : listaPersonas)
        {
            if (p.getNumeroKit() == numeroKit){
                return p.getBarrio();
            }
        }
        return null;
    }


    public void getSanosYAislados(){

        for(Persona p : listaPersonas){
            float temperatura = mapaTesteo.get(p.getNumeroKit()).getTemperatura();

            if(temperatura >= 38)
            {
                lista.addAislados(p, temperatura);
            } else {
                lista.addSanos(p);
            }
        }
    }


    public Integer getCantidadReactivos() {
        return cantidadReactivos;
    }

    public void setCantidadReactivos(Integer cantidadReactivos) {
        this.cantidadReactivos = cantidadReactivos;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }


    @Override
    public String toString() {
        return "SSM{" +
                "cantidadReactivos=" + cantidadReactivos +
                ", listaPersonas=" + listaPersonas +
                '}';
    }
}
