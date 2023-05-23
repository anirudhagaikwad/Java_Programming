package oop;

public class GenericExample {

	public static void main(String[] args) {
	//Generic Class Example
	GenClass<String,Integer> gen=new GenClass<>();
     gen.setT("Hi");
     gen.setV(55);
     System.out.println(gen.getT());
     System.out.println(gen.getV());
     System.out.println(gen.getV().getClass().getName());
     //Generic Constructor Example
     Gen g = new Gen(100);
     Gen g1 = new Gen(121.5f);
     g.show();
     g1.show();
  
	//Generic Method Example
     Pair<Integer, String> p1 = new Pair<>(1, "apple");
     Pair<Integer, String> p2 = new Pair<>(2, "pear");
     boolean same = Util.<Integer, String>compare(p1, p2);
     System.out.println("P1==P2 : "+same);
     
     //Generic Interface Example
     OrderedPair<Integer,String> op=new OrderedPair<>(5,"hello");
     System.out.println(op.getKey()+" : "+op.getValue());
         
   //Bounded type
     Integer[] numbers = {1, 2, 3, 4, 5};
     int co = Count.countGreaterThan(numbers, 3);
     System.out.println("Count: " + co);
}
}//end class

//Generic Class Example
class GenClass<T,V>{
	private T t;
	private V v;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
}//GenClass end


//Generic Constructor
class Gen
{
  private double val;
  <T extends Number> Gen(T ob)
  {
    val = ob.doubleValue();
  }
  void show()
  {
    System.out.println(val);
  }
}//Generic Constructor end



//Generic Method
class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
}

class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}////Generic Method end


//Generic Interface Example
interface Pairr<K, V> {
    public K getKey();
    public V getValue();
}

class OrderedPair<K, V> implements Pairr<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
	this.key = key;
	this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}////Generic Interface Example end

//Bounded type parameters are key to the implementation of 
//generic algorithms.
interface Comparable<T> {
    public int compareTo(T o);
}

class Count{
/*
 * method that counts the number of elements 
 * in an array T[] that are greater than a specified element elem.	
 */
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray) {
            if (e.compareTo(elem) > 0) {
                ++count;
            }
        }
        return count;
    }
	
	/*
	 * public static <T> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray)
        if (e > elem)  // compiler error
            ++count;
    return count;
}

not compile because the greater than operator (>) applies only to primitive types such as short, int, double, long, float, byte, and char. 
You cannot use the > operator to compare objects.
	 */
}