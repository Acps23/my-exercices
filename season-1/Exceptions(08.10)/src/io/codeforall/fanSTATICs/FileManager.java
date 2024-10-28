package io.codeforall.fanSTATICs;

public class FileManager {

    private boolean isLogged = false;

    private File file;

    private File[] files = new File[10];

    public File files[0] = {"Recipes"};




    public void login() {
        isLogged = true;
    }

    public void logout() throws NotEnoughPermissionsException {
        if (isLogged = false) {
           throw new NotEnoughPermissionsException("Not logged in");
        }
        isLogged = false;
    }

    public File getFile(String name) throws FileNotFoundException, NotEnoughPermissionsException {
        if (isLogged = false){
            throw new NotEnoughPermissionsException("Not logged in");
        }
        else {
            for (int i = 0; i < files.length; i++) {
                if (files[i].equals(name)) {
                    return file;
                }
            throw new FileNotFoundException("File not found");


            }
        }
        return file; //only here to compile
    }

    public void createFile(String filename) {

    }
}
