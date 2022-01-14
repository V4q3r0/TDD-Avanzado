package com.example.KataTDD;


public class StringCalculadora {

    public int add(String valores) throws Exception {
        int resultado = 0;
        if(valores.length() > 0){
            try {
                String[] datos = valores.split("[,|\n #]");
                for (String dato: datos){
                    if(Integer.parseInt(dato) < 0){
                        throw new Exception("No se permiten numeros negativos.");
                    }
                    if(Integer.parseInt(dato) <= 1000){
                        resultado += Integer.parseInt(dato);
                    }
                }
            }catch (Exception error){
                resultado = Integer.parseInt(valores);
            }
        }
        return resultado;
    }

}
