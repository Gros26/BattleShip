package com.example.battleship.model.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FileCRUD class for performing Create, Read, Update, and Delete operations on a text file.
 * Provides methods to manipulate file content line by line for the Battleship game.
 * Demonstrates the use of checked, unchecked, and custom exceptions.
 *
 * @author Grosman Garcia
 * @version 1
 */
public class FileCRUD {

    /**
     * Path to the file on which CRUD operations will be performed.
     */
    private final String filePath;

    /**
     * Constructs a new FileCRUD instance with the specified file path.
     *
     * @param filePath the path to the file
     */
    public FileCRUD(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Creates a new line in the file with the specified content.
     * Appends the content to the end of the file.
     *
     * @param content the content to be written to the file
     * @throws FileOperationException if an I/O error occurs
     */
    public void create(String content) throws FileOperationException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath, true))) {
            bw.write(content);
            bw.newLine();
        } catch (IOException e) {
            throw new FileOperationException("Error al crear contenido en el archivo", e);
        }
    }

    /**
     * Reads all lines from the file.
     *
     * @return a list of strings, each representing a line in the file
     * @throws FileOperationException if an I/O error occurs
     */
    public List<String> read() throws FileOperationException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = br.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e) {
            throw new FileOperationException("Error al leer el archivo.", e);
        }
        return lines;
    }

    /**
     * Updates a specific line in the file with the specified content.
     *
     * @param lineIndex the index of the line to be updated
     * @param content the new content for the specified line
     * @throws FileOperationException if an I/O error occurs or the line index is invalid
     * @throws IllegalArgumentException if the line index is invalid (unchecked exception)
     */
    public void update(int lineIndex, String content) throws FileOperationException {
        List<String> lines = this.read();
        if (lineIndex >=  0 && lineIndex < lines.size()) {
            lines.set(lineIndex, content);
            try (BufferedWriter bfWriter = new BufferedWriter(new FileWriter(this.filePath))) {
                for (String line : lines) {
                    bfWriter.write(line);
                    bfWriter.newLine();
                }
            } catch (IOException e) {
                throw new FileOperationException("Error al actualizar el archivo.", e);
            }
        } else {
            throw new IllegalArgumentException("Indice de linea invalido."); // unchecked exception
        }
    }

    /**
     * Deletes a specific line from the file.
     *
     * @param lineIndex the index of the line to be deleted
     * @throws FileOperationException if an I/O error occurs
     * @throws IllegalArgumentException if the line index is invalid (unchecked exception)
     */
    public void delete(int lineIndex) throws FileOperationException {
        List<String> lines = this.read();
        if (lineIndex >=  0 && lineIndex < lines.size()) {
            lines.remove(lineIndex);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                throw new FileOperationException("Error borrando la linea del archivo.", e);
            }
        } else {
            throw new IllegalArgumentException("Indice de la linea invalido."); // unchecked exception
        }
    }
}


