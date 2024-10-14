package io.codeforall.fanSTATICs;

public class NotEnoughPermissionsException extends FileException {

    public NotEnoughPermissionsException(String errorLogout){
        super(errorLogout);
    }

}
