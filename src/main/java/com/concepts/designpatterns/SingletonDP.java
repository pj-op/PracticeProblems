package com.concepts.designpatterns;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDP {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException, CloneNotSupportedException {
        TestSingleton obj1 = TestSingleton.getInstance();
//        TestSingleton obj2 = TestSingleton.getInstance();
        TestSingleton obj2 = null;

        //Using Reflection to break Singleton
        /*Constructor constructor = TestSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        obj2 = (TestSingleton) constructor.newInstance();*/

        //Using Serialization to break Singleton
        /*ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test.txt"));
        outputStream.writeObject(obj1);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.txt"));
        obj2 = (TestSingleton) objectInputStream.readObject();*/

        //Using clone to break singleton
        obj2 = (TestSingleton) obj1.clone();

        System.out.println(obj2 == obj1);


    }
}

class TestSingleton implements Serializable, Cloneable {
    private static TestSingleton instance = null;

    //Preventing Serialization break
    @Serial
    protected Object readResolve() {
        return instance;
    }

    //Preventing Clone break
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not allowed");
    }

    //Preventing Reflection break
    private TestSingleton() throws IllegalAccessException {
        if (null != instance) throw new IllegalAccessException("Not allowed");
    }

    public static TestSingleton getInstance() throws IllegalAccessException {
        if (null == instance) {
            //Preventing multithreaded env break
            synchronized (SingletonDP.class) {
                if (null == instance)
                    instance = new TestSingleton();
            }
        }
        return instance;
    }
}
