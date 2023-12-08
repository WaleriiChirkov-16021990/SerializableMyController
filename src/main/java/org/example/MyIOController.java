package org.example;

import java.io.*;

public class MyIOController<T extends Serializable> {

    public MyIOController() {
    }

    public void saveDataFromFile(T data, String fileName) {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public T loadDataFromFile(String fileName) throws RuntimeException {
        File file = new File(fileName);
        if (!file.exists() || file.isDirectory()) {
            throw new RuntimeException("File not found");
        } else if (file.length() == 0) {
            throw new RuntimeException("File is empty");
        }
        T data;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Object inputObject = ois.readObject();
            data = (T) inputObject;
            ois.close();
            if (file.delete()) {
                System.out.println("File deleted");
            }
            return data;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}

