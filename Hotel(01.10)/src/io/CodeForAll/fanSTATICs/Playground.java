package io.CodeForAll.fanSTATICs;

public class Playground {
    public static void main(String[] args) {

        Hotel hotel = new Hotel(3);
        Person person1 = new Person("Cristina", hotel);
        Person person2 = new Person("João", hotel);

        person1.personCheckIn();
        person1.personCheckOut();

        person2.personCheckIn();
        person2.personCheckOut();

    }
}
