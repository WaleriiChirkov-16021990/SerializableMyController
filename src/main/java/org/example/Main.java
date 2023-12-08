package org.example;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /**
         * Написать класс с двумя методами:
         * 1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл. Название файл - class.getName() + "_" + UUID.randomUUID().toString()
         *
         *
         *
         *
         * 2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString() и загружает объект из файла и удаляет этот файл.
         *
         * Что делать в ситуациях, когда файла нет или в нем лежит некорректные данные - подумать самостоятельно.
         */

//            1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл. Название файл - class.getName() + "_" + UUID.randomUUID().toString()
//            2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString() и загружает объект из файла и удаляет этот файл.
//
        String fileName = MyData.class.getName() + "_" + UUID.randomUUID().toString();
        try {
            File file = new File(fileName);
            file.createNewFile();
            System.out.println("File created: " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        MyData myData = new MyData("Chirkov");
        myData.setMyFieldOne(new MyFieldOne("MyFieldOne", 1));
        myData.setMyFieldTwo(new MyFieldTwo("MyFieldTwo", 2));
        MyIOController<MyData> myIOController = new MyIOController<>();

        System.out.println("Object created: \n" + myData);
        myIOController.saveDataFromFile(myData, fileName);

        // 2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString() и загружает объект из файла и удаляет этот файл.
        MyData loadedData = myIOController.loadDataFromFile(fileName);
        System.out.println("Object loaded: ");
        System.out.println(loadedData);
    }
}