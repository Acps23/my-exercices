package io.CodeForAll.fanSTATICs;

public class Room {
    //Relaciona-se apenas com Hotel

    int nrroom;
    private boolean availableRoom;


    public Room(int nrroom) {
        this.nrroom = nrroom;
        this.availableRoom = true;
    }

    public int getNrroom() {
        return nrroom;
    }

    public boolean GetavailableRoom(){
        return availableRoom;
    }

    public void setAvailableRoom(boolean availableRoom) {
        this.availableRoom = availableRoom;
    }
}




