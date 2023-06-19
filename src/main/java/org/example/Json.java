package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Json {

    public Json() {
    }

    public  void actualizar(SanosYAislados nuevoSanoYAislado)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        List<SanosYAislados> sanosYAilados = new ArrayList<>();

        //RUTA FACULTAD: "C:\\Users\\usuario\\IdeaProjects\\Json\\src\\main\\resources\\persona.json"
        try {
            // Lee el JSON desde un archivo y conviértelo a un arreglo de objetos Persona
            SanosYAislados[] sanosYAisladosArray = objectMapper.readValue(new File("src\\main\\resources\\sanosYAislados.json"), SanosYAislados[].class);
            sanosYAilados.addAll(Arrays.asList(sanosYAisladosArray));

            // Agrega el nuevo objeto Persona al arreglo existente
            sanosYAilados.add(nuevoSanoYAislado);

            // Convierte el arreglo actualizado de objetos Persona a JSON
            String jsonActualizado = objectMapper.writeValueAsString(sanosYAilados);

            // Escribe el JSON resultante en el archivo para reemplazar su contenido existente
            FileWriter fileWriter = new FileWriter("src\\main\\resources\\sanosYAislados.json");
            fileWriter.write(jsonActualizado);
            fileWriter.close();

            System.out.println("Archivo actualizado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  void getPSanosYAislados()
    {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Lee el JSON desde un archivo
            SanosYAislados[] sanosYAislados = objectMapper.readValue(new File("src\\main\\resources\\sanosYAislados.json"), SanosYAislados[].class);

            // Accede a los objetos Persona
            for (SanosYAislados sa : sanosYAislados) {
                System.out.println("Sanos: " + sa.getListaSanos());
                System.out.println("Aislados: " + sa.getListaAislar());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
