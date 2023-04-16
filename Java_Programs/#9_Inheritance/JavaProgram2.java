package PPT9;
/*
Create a class named 'Rectangle' with two data members 'length' and 'breadth' and two methods to print the area and perimeter of the rectangle respectively. Its constructor having parameters for length and breadth is used to initialize length and breadth of the rectangle. Let class 'Square' inherit the 'Rectangle' class with its constructor having a parameter for its side (suppose s) calling the constructor of its parent class as 'super(s,s)'. Print the area and perimeter of a rectangle and 10 squares.
*/

class Rectangle{
    int length;
    int breadth;

    public Rectangle(int l, int b){ //parameterized constuctor
        length = l;
        breadth = b;
    }

    public void printArea(){
        System.out.println(length*breadth); //print area
    }

    public void printPerimeter(){
        System.out.println(2*(length+breadth)); //print perimeter
    }
}

class Square extends Rectangle{
    int side;
    public Square(int s){
        super(s,s); //square has same size of sides so pass it to base Recatangle
    }
}

class JavaProgram2{
    public static void main(String[] args){
        Rectangle r = new Rectangle(4,5);
        r.printArea();
        r.printPerimeter();

        Square s = new Square(4);
        s.printArea();
        s.printPerimeter();

        Square[] a = new Square[10]; //array of objects
        int k = 5;
        //create 10 objects of square
        for(int i = 0;i<10;i++){
            a[i] = new Square(k);
            k++;
        }

        //print area and perimeter of 10 squares
        for(int i = 0;i<10;i++){
            a[i].printArea();
            a[i].printPerimeter();
        }
    }
}


