package ru.lokyanvs;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectOutputStream objOStream = new ObjectOutputStream(new FileOutputStream("serial.txt"));
        MyClass myClass1 = new MyClass("строка 1", 1, 1.0);
        MyClass myClass2 = new MyClass("строка 2", 2, 2.0);
        MyClass myClass3 = new MyClass("строка 3", 3, 3.0);
        System.out.println("myClass1: " + myClass1);
        System.out.println("myClass2: " + myClass2);
        System.out.println("myClass3: " + myClass3);

        objOStream.writeObject(myClass1);
        objOStream.writeObject(myClass2);
        objOStream.writeObject(myClass3);
        objOStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("serial.txt"));
        myClass3 = (MyClass) objectInputStream.readObject();
        myClass2 = (MyClass) objectInputStream.readObject();
        myClass1 = (MyClass) objectInputStream.readObject();
        MyClass myClass = null;
        if (objectInputStream.available() != 0) myClass = (MyClass) objectInputStream.readObject();

        System.out.println();
        System.out.println("После сериализации и десриализации:");
        System.out.println("myClass1=" + myClass1);
        System.out.println("myClass2=" + myClass2);
        System.out.println("myClass3=" + myClass3);
        System.out.println("myClass=" + myClass);
    }
}
