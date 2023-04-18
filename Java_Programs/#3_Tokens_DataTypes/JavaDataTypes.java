package fundamentals;


/*
 * Primitive Datatype
 * 1)Byte Datatype Min Value : -128 Max Value : 127 Size in bit : 8 Size in byte : 1
 * 2)Short Datatype Min Value : -32768 Max Value : 32767 Size in bit : 16 Size in byte : 2
   3)Integer Datatype Min Value : -2147483648 Max Value : 2147483647 Size in bit : 32 Size in byte : 4
   4)Long Datatype Min Value : -9223372036854775808 Max Value : 9223372036854775807 Size in bit : 64 Size in byte : 8
   5)Float Datatype Min Value : 1.4E-45 Max Value : 3.4028235E38 Size in bit : 32 Size in byte : 4
   6)Double Datatype Min Value : 4.9E-324 Max Value : 1.7976931348623157E308 Size in bit : 64 Size in byte : 8
   7)Character Datatype Min Value : ? Max Value : whitespace  Size in bit : 16 Size in byte : 2 
   8)Boolean : true , false
   
    Non-Premitive Datatypes
    String,Array,Class,Interface,Object
 */
public class JavaDataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Byte Datatype Min Value : "+Byte.MIN_VALUE+" Max Value : "+Byte.MAX_VALUE+" Size in bit : "+Byte.SIZE+" Size in byte : "+Byte.BYTES);
		System.out.println("Short Datatype Min Value : "+Short.MIN_VALUE+" Max Value : "+Short.MAX_VALUE+" Size in bit : "+Short.SIZE+" Size in byte : "+Short.BYTES);
		System.out.println("Integer Datatype Min Value : "+Integer.MIN_VALUE+" Max Value : "+Integer.MAX_VALUE+" Size in bit : "+Integer.SIZE+" Size in byte : "+Integer.BYTES);
		System.out.println("Long Datatype Min Value : "+Long.MIN_VALUE+" Max Value : "+Long.MAX_VALUE+" Size in bit : "+Long.SIZE+" Size in byte : "+Long.BYTES);
		System.out.println("Float Datatype Min Value : "+Float.MIN_VALUE+" Max Value : "+Float.MAX_VALUE+" Size in bit : "+Float.SIZE+" Size in byte : "+Float.BYTES);
		System.out.println("Double Datatype Min Value : "+Double.MIN_VALUE+" Max Value : "+Double.MAX_VALUE+" Size in bit : "+Double.SIZE+" Size in byte : "+Double.BYTES);
		System.out.println("Character Datatype Min Value : "+" Max Value : "+" Size in bit : "+Character.SIZE+" Size in byte : "+Character.BYTES);

	}

}