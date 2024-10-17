package io.codeforall.fanstatics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    private FileInputStream in = null;
    private FileOutputStream out = null;

    public static void main(String[] args) {
        String org = "rsc/TESTE.pages";
        String dst = "rsc/Novo.pages";
        FileCopy fileCopy = new FileCopy();
        fileCopy.start(org, dst);
    }

    private void start(String org, String dst) {

        try {
            this.in = new FileInputStream(org);
            this.out = new FileOutputStream(dst);

            byte[] buffer = new byte[1024];

            int num = in.read(buffer);


            while (num != -1) {
                System.out.println("I have read this many bytes: " + num);
                out.write(buffer,0 ,num);
                num = in.read(buffer);
            }
            in.close();

            out.close();


        } catch (IOException e) {
            System.out.println("The file was not found");
        }


    }

    private void cleanUp() {

    }
}
