package baekjoon.inputoutput;

import java.io.IOException;

public class InputOutput_10171 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // StringBuilder sb = new StringBuffer();
        sb.append("\\    /\\\n");
        sb.append(" )  ( ')\n");
        sb.append("(  /  )\n");
        sb.append(" \\(__)|\n");

        System.out.println(sb);
    }
}

/*
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("\\    /\\");
        bw.newLine();	// \n과 같은 역할

        bw.write(" )  ( ')");
        bw.newLine();

        bw.write("(  /  )");
        bw.newLine();

        bw.write(" \\(__)|");

        bw.flush();
        bw.close();

                StringBuilder sb = new StringBuilder();
                // StringBuilder sb = new StringBuffer();
                sb.append("\\    /\\\n");
                sb.append(" )  ( ')\n");
                sb.append("(  /  )\n");
                sb.append(" \\(__)|\n");

                System.out.println(sb);*/
