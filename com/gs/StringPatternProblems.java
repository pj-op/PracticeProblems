package com.gs;

import javax.sound.midi.Soundbank;
import java.util.*;

public class StringPatternProblems {

    public static void main(String[] args) {

//        1. Dist. Between Strings
        String document = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements";
        String first = "is", second = "a";
//        System.out.println(shortestDistanceBetweenStrings(document, first, second));

//        2. Longest Word
        String[] dict = new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"};
        String letter = "oetdg";
//        System.out.println(getLongestWord(dict, letter));

//        3. Apache Log Pattern
        String lines[] = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"};
//        System.out.println(findTopIps(lines));

//       4. First NonRepeating Character
        String fnrChar = "xxyyzz";
//        System.out.println(firstNonRepeatingChar(fnrChar));

//        5. Group anagrams
        String grps[] = {"cat", "dog", "god"};
//        System.out.println(groupAnagramsTogether(grps));

//          6. Longest Uniform Substring
        String str = "aaaaabbbbbbbCdAAzzzzzzzzzzzzzzzzzzzzzzz";
//        System.out.println(Arrays.toString(getLongestUniformSubStringDetails(str)));

//           7. Run Length Encoding
        String decodedString = "aabbbaa";
//        System.out.println(getEncodedString(decodedString));

//           8. Pangram
        String sentence = "The slow purple oryx meanders past the quiescent canine";
//        System.out.println(getMissingChars(sentence));

//          9. Reverse String
        String revString = "abcd";
//        System.out.println(getReverseOfString(revString));

//        10. Reverse String with Bug
        String bugString = "ab%c-dr*df_";
//        System.out.println(getReverseOfBugString(bugString));



    }

    private static String getReverseOfBugString(String bugString) {
        int i = 0, j = bugString.length() - 1;
        char result[] = bugString.toCharArray();

        while (i < j) {
            if (!Character.isAlphabetic(bugString.charAt(i))) {
                i++;
            } else if (!Character.isAlphabetic(bugString.charAt(j))) {
                j--;
            } else {
                char temp = result[i];
                result[i] = result[j];
                result[j] = temp;
                i++;
                j--;
            }

        }


        return String.valueOf(result);
    }

    private static String getReverseOfString(String revString) {
        char[] str = new char[revString.length()];

        /*for (int i = 0; i < str.length; i++) {
            str[i] = revString.charAt(str.length - i - 1);
        }*/

        char sArr[] = revString.toCharArray();
        int i = 0, j = revString.length() - 1;

        while (i < j) {
            char temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            i++;
            j--;
        }


        return String.valueOf(sArr);
    }

    private static String getMissingChars(String sentence) {
        StringBuilder sb = new StringBuilder();
        String inputString = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        System.out.println(inputString);
        int char_count[] = new int[26];

        for (char c : inputString.toCharArray()) {
            char_count[c - 'a']++;
        }

        for (int i = 0; i < char_count.length; i++) {
            if (char_count[i] == 0) {
                sb = sb.append((char) ('a' + i));
            }
        }


        return sb.toString();
    }

    private static String getEncodedString(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < str.length()) {
            sb.append(str.charAt(i));
            while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                j++;
            }
            int diff = j - i;
            sb.append(diff);
            i = j;
        }


        return sb.toString();
    }

    private static int[] getLongestUniformSubStringDetails(String str) {
        int i = 0, j = 0, maxLength = Integer.MIN_VALUE, result[] = new int[2];

        while (i < str.length()) {
            while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                j++;
            }
            int diff = j - i;
            if (diff > maxLength) {
                maxLength = diff;
                result[0] = j - diff;
                result[1] = diff;
            }
            i = j;
        }

        return result;
    }

    private static Set<Set<String>> groupAnagramsTogether(String[] grps) {
        HashMap<String, Set<String>> anagramsMap = new HashMap<>();
        Set<String> simillarStrings = new HashSet<>();

        for (String word : grps) {
            if (anagramsMap.containsKey(getSortedString(word))) {
                simillarStrings = anagramsMap.get(getSortedString(word));
                simillarStrings.add(word);
                anagramsMap.put(getSortedString(word), simillarStrings);
            } else {
                Set<String> newStrings = new HashSet<>();
                newStrings.add(word);
                anagramsMap.put(getSortedString(word), newStrings);
            }
        }
//        System.out.println(anagramsMap);
        return new HashSet<>(anagramsMap.values());
    }

    private static String getSortedString(String str) {
        char[] s = str.toCharArray();
        Arrays.sort(s);
        return String.valueOf(s);
    }

    private static char firstNonRepeatingChar(String fnrChar) {
        int char_count[] = new int[26];

        for (char c : fnrChar.toCharArray()) {
            char_count[c - 'a']++;
        }

        for (char c : fnrChar.toCharArray()) {
            if (char_count[c - 'a'] == 1) {
                return c;
            }
        }


        return '0';
    }

    private static Set<String> findTopIps(String[] lines) {
        int maxOccur = 0;
        HashMap<String, Integer> ips = new HashMap<>();
        Set<String> res = new HashSet<>();

        for (String str : lines) {
            String ip = str.substring(0, str.indexOf("-")).trim();
            ips.put(ip, ips.getOrDefault(ip, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : ips.entrySet()) {
            maxOccur = Math.max(maxOccur, entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : ips.entrySet()) {
            if (entry.getValue() == maxOccur) {
                res.add(entry.getKey());
            }
        }

//        System.out.println(ips);

        return res;
    }

    private static Set<String> getLongestWord(String[] dict, String letter) {
        Set<String> result = new HashSet<>();
        int minLength = 0;

        for (String word : dict) {
            if (minLength < word.length()) {
                if (getCharSet(letter).containsAll(getCharSet(word))) {
                    result.clear();
                    result.add(word);
                    minLength = word.length();
                }
            } else if (minLength >= word.length()) {
                if (getCharSet(letter).containsAll(getCharSet(word))) {
                    result.add(word);
                }
            }
        }
        return result;

    }

    private static Set<Character> getCharSet(String str) {
        Set<Character> c = new HashSet<>();

        for (char chars : str.toCharArray()) {
            c.add(chars);
        }
        return c;
    }

    private static double shortestDistanceBetweenStrings(String document, String one, String two) {
        double dist1Var = 0, dist2Var = 0, minLength = Integer.MAX_VALUE, totalLength = 0;
        String words[] = document.split(" ");

        for (String word : words) {
            if (word.equals(one)) {
                dist1Var = totalLength + word.length() / 2d;
            } else if (word.equals(two)) {
                dist2Var = totalLength + word.length() / 2d;
            }

            if (dist1Var > 0 && dist2Var > 0) {
                double current = Math.abs(dist1Var - dist2Var);
                if (current < minLength) {
                    minLength = current;
                }
            }
            totalLength = totalLength + word.length() + 1;
        }


        return minLength;
    }
}
