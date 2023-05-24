package CollectionCRUD;

import java.util.*;
class MapProgram {
    public static void main(String args[])
    {
        // Default Initialization of a
        // Map
        Map<Integer, String> hm1 = new HashMap<>();

        // Initialization of a Map
        // using Generics
        Map<Integer, String> hm2
                = new HashMap<Integer, String>();

        // Inserting the Elements
        hm1.put(1, "TRAIN");
        hm1.put(2, "BUS");
        hm1.put(3, "CAR");

        hm2.put(new Integer(1), "CPP");
        hm2.put(new Integer(2), "JAVA");
        hm2.put(new Integer(3), "PYTHON");

        System.out.println(hm1);
        System.out.println(hm2);

        //removing--
        // Initial Map
        System.out.println(hm1);
        hm1.remove(new Integer(4));
        // Final Map
        System.out.println(hm1);

        //traverse:--
        for (Map.Entry mapElement : hm1.entrySet()) {
            int key= (int)mapElement.getKey();
            // Finding the value
            String value= (String)mapElement.getValue();
            System.out.println(key + " : "+ value);
        }
    }
}

