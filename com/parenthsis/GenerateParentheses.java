package com.parenthsis;

import javax.sound.sampled.AudioFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses implements Serializable {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        int num = 10;

        /*FileOutputStream fos = new FileOutputStream("ans.txt");
        ByteArrayOutputStream b = new ByteArrayOutputStream();

        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(findAll("(", 1, 0, result, num));

        byte[] listToBytes = b.toByteArray();

        fos.write(listToBytes);*/
        FileWriter fw = new FileWriter("ans.txt");

        for (String s : findAll("(", 1, 0, result, num)) {
            fw.write(s + System.lineSeparator());
        }

        fw.close();

//        System.out.println(findAll("(", 1, 0, result, num));
//        generateParenthsis(num);
    }

    public static void generateParenthsis(int num) {
        String left = "(";
        String right = ")";
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i + 2; j++) {
                sb = sb.append(left).append(right);
            }
        }

        System.out.println(sb.toString());


    }

    static List<String> findAll(String s, int o, int c, List<String> result, int num) {

        if (s.length() == num * 2) {
            result.add(s);
        }
        if (o < num) findAll(s + "(", o + 1, c, result, num);
        if (c < o) findAll(s + ")", o, c + 1, result, num);

        return result;
    }

}
