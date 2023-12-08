package org.example;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Написать класс с двумя методами:
 * 1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл.
 * Название файл - class.getName() + "_" + UUID.randomUUID().toString()
 * 2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString()
 * и загружает объект из файла и удаляет этот файл.
 * Что делать в ситуациях, когда файла нет или в нем лежит некорректные данные - подумать самостоятельно.
 */
public class Main {
    public static void main(String[] args) {
        String fileName = MyData.class.getName() + "_" + UUID.randomUUID().toString();
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyData myData = new MyData("Chirkov");
        myData.setMyFieldOne(new MyFieldOne("MyFieldOne", 1));
        myData.setMyFieldTwo(new MyFieldTwo("MyFieldTwo", 2));
        MyIOController<MyData> myIOController = new MyIOController<>();

        System.out.println("Object created: \n" + myData);
        try {
            myIOController.saveDataFromFile(myData, fileName);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        MyData loadedData;
        try {
            loadedData = myIOController.loadDataFromFile(fileName);
            System.out.println("Object loaded: ");
            System.out.println(loadedData);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}