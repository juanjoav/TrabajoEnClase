/*
 * Copyright (c) 25/4/2021.
 * Created by Juan Ariza and Harrison Diaz
 * All rights reserved
 */

package persistence;

import models.*;
import org.json.simple.*;
import views.utils.Components;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MyJsonFile {

    public static final String KEY_JSON = "Respuestas de formulario 1";
    public static final String KEY_NAME = "Nombre:";
    public static final String KEY_LAST_NAME = "Apellido:";
    public static final String KEY_DOCUMENT = "Tipo de Documento:";
    public static final String KEY_ID = "Numero de Documento(6 digitos):";
    public static final String KEY_GENDER = "Genero";
    public static final String KEY_DATA = "Fecha de nacimiento:";
    public static final String KEY_PAYMENT = "Tipo de pago";
    public static final String KEY_PLAN = "Plan";
    public static final String KEY_TRAINING = "Tipo de entrenamiento";
    public static final String KEY_HEIGHT = "Altura(solo numero)";
    public static final String KEY_WEIGHT = "Peso(solo numero)";
    public static final String KEY_RESPONSIBLE_ADULT = "Adulto responsable";
    public static final String KEY_RESPONSIBLE_TRAINER_ID = "Id del entrenador";

    /**
     * Este metodo lee el archivo Json
     * @param filePath la ruta del archivo
     * @return Una lista de usuarios
     */
    public static ArrayList<User> readFile(String filePath) {
        ArrayList<User> userList = new ArrayList<>();
        JsonObject jsonObjectRoot;

        try {
            jsonObjectRoot = (JsonObject) Jsoner.deserialize(new FileReader(filePath));
            JsonArray jsonArrayDatos = (JsonArray) jsonObjectRoot.get(KEY_JSON);
            for (int j = 0; j < jsonArrayDatos.size(); j++) {
                JsonObject jsonObjectUser = (JsonObject) jsonArrayDatos.get(j);
                String name = jsonObjectUser.getString(KEY_NAME);
                String lastName = jsonObjectUser.getString(KEY_LAST_NAME);
                String documentType = jsonObjectUser.getString(KEY_DOCUMENT);
                //String documentNumber = "56879";//jsonObjectUser.getString(KEY_ID);
                String id = jsonObjectUser.getString(KEY_ID);
                String gender = jsonObjectUser.getString(KEY_GENDER);
                String date = jsonObjectUser.getString(KEY_DATA);
                String pay = jsonObjectUser.getString(KEY_PAYMENT);
                String plan = jsonObjectUser.getString(KEY_PLAN);
                String trainType = jsonObjectUser.getString(KEY_TRAINING);
                String height = jsonObjectUser.getString(KEY_HEIGHT);
                String weight = jsonObjectUser.getString(KEY_WEIGHT);

                String responsibleAdult = jsonObjectUser.getString(KEY_RESPONSIBLE_ADULT);
                String trainerId = jsonObjectUser.getString(KEY_RESPONSIBLE_TRAINER_ID);

                userList.add(new User(name, lastName, DocumentType.valueOf(documentType), Integer.parseInt(id), Gender.valueOf(gender), Components.toStringReadLocalDate(date),
                        Plan.valueOf(plan), TrainType.valueOf(trainType), PaymentType.valueOf(pay), Double.parseDouble(height), Double.parseDouble(weight), responsibleAdult, Integer.parseInt(trainerId)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DeserializationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * Este metodo escribe el Json
     * @param filePath
     * @param userArrayList
     */
    public static void saveFile(String filePath, ArrayList<User> userArrayList) {
        JSONObject jsonObject = new JSONObject();
        JsonArray jsonArray = new JsonArray();

        for (int i = 0; i < userArrayList.size(); i++) {
            JSONObject aux = new JSONObject();

            aux.put(KEY_NAME, userArrayList.get(i).getName());
            aux.put(KEY_LAST_NAME, userArrayList.get(i).getLastName());
            aux.put(KEY_DOCUMENT, userArrayList.get(i).getDocumentType().toString());
            aux.put(KEY_ID, "" + userArrayList.get(i).getId());
            aux.put(KEY_GENDER, userArrayList.get(i).getGender().toString());
            aux.put(KEY_DATA, Components.toSaveLocalDate(userArrayList.get(i).getDate()));
            aux.put(KEY_PAYMENT, userArrayList.get(i).getPayment().toString());
            aux.put(KEY_PLAN, userArrayList.get(i).getPlan().toString());
            aux.put(KEY_TRAINING, userArrayList.get(i).getTrainType().toString());
            aux.put(KEY_HEIGHT, "" + userArrayList.get(i).getHeight());
            aux.put(KEY_WEIGHT, "" + userArrayList.get(i).getWeight());

            aux.put(KEY_RESPONSIBLE_ADULT, userArrayList.get(i).getResponsibleAdult());
            aux.put(KEY_RESPONSIBLE_TRAINER_ID, "" + userArrayList.get(i).getTrainnerID());
            jsonArray.add(aux);
        }
        jsonObject.put(KEY_JSON, jsonArray);

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
}