public class Book{
    public static void main(String[] args){
	Book a = new Book();
	Book b = new Book("Donald E. Knutz","The Art of Computer Programming","9780201311204");
	System.out.println(a);
	System.out.println(b);
	System.out.println(a.getAuthor());
	System.out.println(b.getAuthor());
	System.out.println(b.getTitle());
	System.out.println(b.getISBN());
    }
    private String author;
    private String title;
    private String isbn;

    public Book(){
    }

    public Book(String a, String t, String i){
	author=a;
	title=t;
	isbn=i;
    }

    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return isbn;
    }

    public void setAuthor(String author){
	this.author=author;
    }
    public void setTitle(String title){
	this.title=title;
    }
    public void setISBN(String isbn){
	this.isbn=isbn;
    }

    public String toString(){
	return "Title: "+ title+
	    " Author: "+author+
	    " ISBN: "+isbn;
    }
}
