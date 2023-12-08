package org.example;

import java.io.*;

public class MyIOController<T extends Serializable> {

    public MyIOController() {
    }

    public <T extends Serializable> void saveDataFromFile(T data, String fileName) {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public <T extends Serializable> T loadDataFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists() || file.isDirectory()) {
            throw new RuntimeException("File not found");
        } else if (file.length() == 0) {
            throw new RuntimeException("File is empty");
        }
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            //noinspection unchecked
            T data = (T) ois.readObject();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

