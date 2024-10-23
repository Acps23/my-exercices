package io.codeforall.fanSTATICs;

public class NotEnoughSpaceException extends FileException {
    public NotEnoughSpaceException(String noSpace){
        super(noSpace);
    }
}
