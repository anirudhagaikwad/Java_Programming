package PPT16;

// Java Program to serialize and deserialize the lambda function using a function interface

// Importing input output classes
import java.io.*;
// Importing all function utility classes
import java.util.function.*;

// Interface
interface MyInterface {

    // Method inside this interface
    void hello(String name);
}

// Class 1
// Helper class implementing above interface
class MyImpl implements MyInterface {

    // Method of this class
    public void hello(String name)
    {
        System.out.println("Hello " + name);
    }
}

// Class 2 Main class
class JavaProgram4 {

    // Method 1
    // To Serialize
    private static void serialize(Serializable obj,
                                  String outputPath)
            throws IOException
    {
        File outputFile = new File(outputPath);
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        try (ObjectOutputStream outputStream
                     = new ObjectOutputStream(
                new FileOutputStream(outputFile))) {
            outputStream.writeObject(obj);
        }
    }

    // Method 2
    // To Deserialize
    private static Object deserialize(String inputPath)
            throws IOException, ClassNotFoundException
    {
        File inputFile = new File(inputPath);
        try (ObjectInputStream inputStream
                     = new ObjectInputStream(
                new FileInputStream(inputFile))) {
            return inputStream.readObject();
        }
    }

    // Method 3
    // To Serialize and deserialize lambda functions
    private static void serializeAndDeserializeFunction()
            throws Exception
    {
        Function<Integer, String> fn
                = (Function<Integer, String> & Serializable)(n)
                -> "Hello " + n;
        System.out.println("Run original function: "
                + fn.apply(10));

        String path = "./serialized-fn";

        serialize((Serializable)fn, path);
        System.out.println("Serialized function to "
                + path);

        Function<Integer, String> deserializedFn
                = (Function<Integer, String>)deserialize(path);
        System.out.println("Deserialized function from "
                + path);
        System.out.println("Run deserialized function: "
                + deserializedFn.apply(11));
    }

    // Method 4
    // To Serialize and deserialize lambda classes
    private static void serializeAndDeserializeClass()
            throws Exception
    {
        String path = "./serialized-class";
        serialize(MyImpl.class, path);
        System.out.println("Serialized class to " + path);

        // Pretending we don't know the exact class of the
        // serialized bits, create an instance from the
        // class and use it through the interface.
        Class<?> myImplClass = (Class<?>)deserialize(path);
        System.out.println("Deserialized class from "
                + path);
        MyInterface instance
                = (MyInterface)myImplClass.newInstance();
        instance.hello("Java");
    }


    public static void main(String[] args) throws Exception
    {

        // Calling above method 3 and method 4 in the main() body
        serializeAndDeserializeFunction();
        serializeAndDeserializeClass();
    }
}

