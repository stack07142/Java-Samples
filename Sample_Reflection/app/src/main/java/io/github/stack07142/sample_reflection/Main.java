package io.github.stack07142.sample_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Reflection is an API which is used to examine or modify the behavior of methods, classes, interfaces at runtime.
 *
 * 1. The required classes for reflection are provided under java.lang.reflect package.
 * 2. Reflection gives us information about the class to which an object belongs and also the methods of that class which can be executed by using the object.
 * 3. Through reflection we can invoke methods at runtime irrespective of the access specifier used with them.
 *
 * - Class        : The getClass() method is used to get the name of the class to which an object belongs.
 * - Constructors : The getConstructors() method is used to get the public constructors of the class to which an object belongs.
 * - Methods      : The getMethods() method is used to get the public methods of the class to which an objects belongs.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Test obj = new Test();

        // 1. Creating class object from the object using getClass method
        Class cls = obj.getClass();
        System.out.println("\n*** The name of class is " + cls.getName());

        // 2. Getting the constructor of the class through the object of the class
        Constructor constructor = cls.getConstructor();
        System.out.println("\n*** The name of constructor is " + constructor.getName());

        // 3. Getting methods of the class through the object of the class by using getMethods
        System.out.println("\n*** The public methods of class are : ");

        Method[] methods = cls.getMethods();

        for (Method method : methods) {

            System.out.println(method.getName());
        }

        // 4. Creates object of desired method by providing the method name and parameter class as arguments to the getDeclaredMethod
        System.out.println("\n*** Invokes the method at runtime ");
        Method methodCall1 = cls.getMethod("method1");
        Method methodCall2 = cls.getMethod("method2", int.class);

        // invokes the method at runtime
        methodCall1.invoke(obj);
        methodCall2.invoke(obj, 19);

        // 5. Creates object of the desired field by providing the name of field as argument to the getDeclaredField method
        Field field = cls.getDeclaredField("s");

        // allow the object to access the field irrespective of the access specifier used with the field
        field.setAccessible(true);

        // takes object and the new value to be assigned to the field as arguments
        field.set(obj, "Java");

        methodCall1.invoke(obj);

        Method methodcall3 = cls.getDeclaredMethod("method3");

        // allow the object to access the method irrespective of the access specifier used with the method
        methodcall3.setAccessible(true);

        // invokes the method at runtime
        methodcall3.invoke(obj);



    }
}

class Test {

    private String s;

    public Test() {

        s = "GeeksforGeeks";
    }

    public void method1() {

        System.out.println("The string is " + s);
    }

    public void method2(int n) {

        System.out.println("The number is " + n);
    }

    private void method3() {

        System.out.println("Private method invoked");
    }
}