package top.elgong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class test{

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String line1 = br.readLine();
            System.out.println(line1);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}