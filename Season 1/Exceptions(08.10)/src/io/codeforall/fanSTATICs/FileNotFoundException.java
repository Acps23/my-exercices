package io.codeforall.fanSTATICs;

public class FileNotFoundException extends FileException{
    public FileNotFoundException(String fileDontExist){
        super(fileDontExist);
    }
}
