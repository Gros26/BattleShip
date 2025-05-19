package com.example.battleship.model.utils;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
 * Serialization utility class for serializing and deserializing objects to and from a file in the Battleship game.
 * Provides static methods for saving, loading, and clearing game state.
 *
 * @author Grosman Garcia
 * @version 1
 */
public class Serialization {
    /**
     * Path to the file used for serialization.
     */
    private static Path relativePath = Paths.get("objectsSerialization.txt");

    /**
     * Returns the relative path to the serialization file as a string.
     *
     * @return the relative path to the serialization file
     */
    public static String getRelativePath() {return relativePath.toString();}

    /**
     * Default constructor for Serialization.
     */
    public Serialization() {
    }

    /**
     * Serializes the given objects to the specified file.
     *
     * @param fileName the name of the file to which the objects will be serialized
     * @param objects the objects to be serialized
     */
    public static void serializeObjects(String fileName, Object... objects) {
        String path = getRelativePath();
        File file = new File(path);

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Object obj : objects) {
                oos.writeObject(obj);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deserializes objects from the specified file.
     *
     * @param fileName the name of the file from which the objects will be deserialized
     * @return a list of deserialized objects
     */
    public static List<Object> deserializeObjects(String fileName) {
        List<Object> objects = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    objects.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    /**
     * Clears the contents of the specified file.
     *
     * @param fileName the name of the file to be cleared
     * @throws IOException if an I/O error occurs
     */
    public static void clearFile(String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {

        }
    }
}
