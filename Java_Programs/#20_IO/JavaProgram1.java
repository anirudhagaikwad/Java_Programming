package PPT20;
/*
JAVA program for Moving a file from one directory to another using Java
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;

public class JavaProgram1
{
    public static void main(String[] args) throws IOException
    {
        //move the file and store path in temp
        Path temp = Files.move
                (Paths.get("C:\\Users\\Vaibhavi\\Downloads\\1637582103.pdf"),
                        Paths.get("C:\\Users\\Vaibhavi\\Documents\\my.pdf"));

        if(temp != null) //check if path is not null
        {
            System.out.println("File renamed and moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
    }
}


