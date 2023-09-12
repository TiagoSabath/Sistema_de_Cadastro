package com.example.sistemadecadastro;

import java.util.ArrayList;

public class RegistrosManager {
    private static ArrayList<Registro> registros = null;

    public static ArrayList<Registro> getRegistros() {
        if(registros == null){
            registros = new ArrayList<Registro>();
        }
        return registros;
    }
}
