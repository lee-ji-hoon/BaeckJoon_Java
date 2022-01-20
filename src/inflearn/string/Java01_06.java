package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java01_06 {

/*    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            if (str.indexOf(str.charAt(i)) == i) sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Java01_06 T = new Java01_06();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(T.solution(str));
    }*/

    public String solution(String str) {
        StringBuilder sb = new StringBuilder();

        Set<String> linkedHashSet = new LinkedHashSet<String>();
        for (char x : str.toCharArray()) {
            linkedHashSet.add(String.valueOf(x));
        }

        Iterator<String> linkedIter = linkedHashSet.iterator();

        while(linkedIter.hasNext()) {
            sb.append(linkedIter.next());
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Java01_06 T = new Java01_06();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
