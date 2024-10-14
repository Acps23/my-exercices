package io.codeforall.fanSTATICs;

import io.codeforall.fanSTATICs.FileManager;

public class Main {
    public static void main(String[] args) {

        FileManager windows = new FileManager();




        try {
            windows.logout();
            windows.login();
            windows.getFile("Potato");
            windows.createFile("Potato");
        } catch (NotEnoughPermissionsException errorLogout) {
            System.out.println("Not enough permission");
        /*} catch (NotEnoughSpaceException noSpace){
            System.out.println("Not enough Space");*/
        } catch (FileNotFoundException fileDontExist) {
            System.out.println("File not found");
        }


    }
}
