import java.lang.*;
public class ReferenceBook extends LibraryBook{
    public static void main(String[] args){
	ReferenceBook a = new ReferenceBook("D. Knutz","The Art of Computer Programming","00029430149","0892734109","Stuyvesant High School Library");
	System.out.println(a);
    }
    
    public String collection;
    public ReferenceBook(String author, String title, String isbn, String callNumber, String collection){
	super(author,title,isbn,callNumber);
	this.collection=collection;
    }

    public String getCollection(){
	return collection;
    }
    public void setCollection(String collection){
	this.collection=collection;
    }
    public void checkout(String patron, String due){
	throw new UnsupportedOperationException("reference book cannot be checked out");
    }
    public void returned(){
	throw new UnsupportedOperationException("reference book could not have been returned");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
	return super.toString()+
	    " Collection: "+
	    getCollection();
    }
}
