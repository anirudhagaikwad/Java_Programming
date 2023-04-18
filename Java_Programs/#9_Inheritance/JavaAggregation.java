package oop;

/*
 * Has-A Relationship : It also called Composition,An instance of another class has referance to an instance of another class
 * Aggregation : It is term which is used to refer one way relationship between two objects ,Its represent Has-A relationship
 * 
 */
public class JavaAggregation {

	public static void main(String[] args) {
	
		Author objAuthor=new Author("Chetan Bhagat","Mumbai","22 April 1974");
		Book objBook=new Book(objAuthor,"Immortals of Meluha","IOM0001");
		// Book details
		System.out.println("Book Name : "+objBook.name);
		System.out.println("Book ID : "+objBook.publisherId);
		
		// Author details
		System.out.println("Author Name : "+objBook.author.name);
		System.out.println("Author Birth Date : "+objBook.author.birthDate);
		System.out.println("Author Location : "+objBook.author.location);

	}//main()

}//JavaAggregation


class Author{
	String name;
	String location;
	String birthDate;
	public Author(String name, String location, String birthDate) {
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	} //constructor
}//Author

class Book{
	Author author;
	String name;
	String publisherId;
	
	public Book(Author author, String name, String publisherId) {
		this.author = author;
		this.name = name;
		this.publisherId = publisherId;
	}//constructor
	
}//Book

