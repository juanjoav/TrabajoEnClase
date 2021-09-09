/*
 * Copyright (c) 17/3/2021.
 * Created by Juan Jose Ariza Velasco
 * All rights reserved
 */

package persistence;

import java.io.*;

public class MyFile {

    private File file;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedWriter bufferWriter = null;
    private BufferedReader bufferReader = null;

    public static final char DOCUMENT_WRITE = 'w';
    public static final char DOCUMENT_READ = 'r';

    public MyFile(String nameFile) {
        file = new File(nameFile);
    }

    /**
     * Este metodo abre el archivo
     * @param modo
     */
    public void open(char modo)	{
        try {
            if (modo == DOCUMENT_WRITE ){
                fileWriter = new FileWriter(file);
                bufferWriter = new BufferedWriter(fileWriter);
            } else{
                fileReader = new FileReader(file);
                bufferReader = new BufferedReader(fileReader);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Este metodo almacena la cadena entrante de datos
     * @param cad una cadena de caracteres
     */
    public void burn(String cad){
        if (bufferWriter != null){
            try {
                bufferWriter.write(cad);
                bufferWriter.newLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * Este metodo lee una linea del archivo plano del csv
     * @return
     */
    public String reader(){
        String cad = "";
        try {
            cad = bufferReader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cad;
    }

    /**
     * Este metodo cierra la lectura del
     */
    public void close(){
        try {
            if (bufferReader != null)
                bufferReader.close();
            if (bufferWriter != null)
                bufferWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

