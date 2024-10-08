package io.CodeForAll.fanSTATICs;

public class Hotel {
    //Relaciona-se Person e Rooms


    private Room[] rooms;
    private int gettedroom;
    private Person person;
    private Room rooms1;

    public Hotel(int totalRooms) {

        this.rooms = new Room[totalRooms];
        for (int i = 0; i < totalRooms; i++) {
            this.rooms[i] = new Room(i + 1);
        }
    }

    public void checkIn() {

    //Invocar outra metodo que esta em rooms(verificar se esta disponivel)
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].GetavailableRoom() == true){
                rooms[i].setAvailableRoom(false);
                gettedroom = rooms[i].getNrroom();
                return;
            }
                System.out.println("No room is available");
            }
        }

    public void checkOut() {

        //Liberta o gettedRoom
    if(gettedroom != 0){
        System.out.println("Check out from room "+ gettedroom);
       //Colocar quarto indisponivel
        rooms[gettedroom-1].setAvailableRoom(false);
        return;
    }
        System.out.println("You don't have a room!");
    }

    public int getGettedroom() {
        return gettedroom;
    }
}
