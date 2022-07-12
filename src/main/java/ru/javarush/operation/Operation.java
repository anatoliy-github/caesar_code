package ru.javarush.operation;

import ru.javarush.operation.exception.HackerException;

import java.io.*;
import java.util.List;

public class Operation {
    Alphabets alphabets = Alphabets.getInstance();

    public void encryption(String pathToReadFile,String pathToWriteFile, int keyEncryption) {
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToReadFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToWriteFile)) ) {
            List<Character> alphabet = alphabets.getListAlphabetByKey("English");

            while(reader.ready()) {
                char ch = (char) reader.read();
                ch = Character.toLowerCase(ch);
                for (int i = 0; i < alphabet.size(); i++) {
                    if(alphabet.get(i) == ch) {
                        int key = (i + keyEncryption) % alphabet.size();
                        ch =alphabet.get(key);
                        break;
                    }
                }
                writer.append(ch);
            }
            writer.flush();
        } catch(IOException e) {
            System.out.println("Error file input/output " + e.getMessage());
        }
    }

    public void decryption(String pathToReadFile,String pathToWriteFile, int keyEncryption) throws HackerException {
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToReadFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToWriteFile)) ) {
            List<Character> alphabet = alphabets.getListAlphabetByKey("English");

            while(reader.ready()) {
                char ch = (char) reader.read();
                ch = Character.toLowerCase(ch);
                for (int i = 0; i < alphabet.size(); i++) {
                    if(alphabet.get(i) == ch) {
                        int key = (alphabet.size() + i - keyEncryption) % alphabet.size();
                        ch =alphabet.get(key);
                        break;
                    } else {
                        throw new HackerException("Symbol "+ ch +" not found in alphabet. Program is stopped");
                    }
                }
                writer.append(ch);
            }
            writer.flush();
        } catch(IOException e) {
            System.out.println("Error file input/output " + e.getMessage());
        }
    }

}
