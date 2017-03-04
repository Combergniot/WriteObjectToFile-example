package com.sdajava.writeObjects;

import java.io.*;

public class Main {

    public static void main  (String[] args) {
	// write your code here

        String fileName = "c://Users//RENT//Moje dokumenty//obiekty.txt";

        Person p1 = new Person("Jan", "Kowalski", 53);
        Person p2 = new Person("John", "Smith", 34);
        Person p3 = new Person("Jane", "Bond", 23);

        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream(new File(fileName));
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(p1);
            objectOutputStream.writeObject(p2);
            objectOutputStream.writeObject(p3);



            //odczyt obiektów z pliku

            FileInputStream fileInputStream
                    = new FileInputStream(fileName);
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);

            while (objectInputStream.readObject() !=null){

                Person output = (Person) objectInputStream.readObject(); //Rzutowanie na klasę Person
                System.out.println(output.getName());
            }

            fileInputStream.close();
            objectInputStream.close();
            fileOutputStream.close();
            objectOutputStream.close();


        }catch (FileNotFoundException error)
        {error.printStackTrace();
        }catch (IOException error){
            error.printStackTrace();
        }catch (ClassNotFoundException error){
            error.printStackTrace();
        }

    }
}
