package com.Strings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StringCheckJava {
    public static void main(String[] args) throws IOException {
        String word = "java";
        File file = new File("C:\\PJOP_STS\\Practice\\PRACTICE\\src\\com\\Strings\\doc.txt");
        System.out.println(readDoc(file, word));
    }

    private static int readDoc(File file, String word) throws IOException {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        FileInputStream fis = new FileInputStream(file);
        int i = 0;
        while ((i = fis.read()) != -1) {
            sb = sb.append((char) i);
        }
        String s = sb.toString().toLowerCase().replaceAll("[^0-9a-zA-Z ]", "");
        for (String str : s.split(" ")) {
            if (str.equalsIgnoreCase(word) || str.contains(word)) count++;
        }

        return count;
    }
}
