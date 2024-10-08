package io.CodeForAll.fanSTATICs;

public class Person {

    private String name;
    private int gettedRoom;
    private Hotel hotel;
    int nrRoom;

    public Person(String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;
    }

    public void personCheckIn() {

        System.out.println(name);
        //invoca o metodo do hotel para checkin
        hotel.checkIn();

        //recebe o GettedRoom do hotel
        this.gettedRoom = hotel.getGettedroom();
        System.out.println("Your room is " + gettedRoom);
    }

    public void personCheckOut() {
        hotel.checkOut();
        //Invoca o metodo do hotel para checkout

    }

}
