public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String isbn, String callNumber){
	super();
	currentHolder=null;
	dueDate=null;
    }

    public String getCurrentHolder(){
	return currentHolder;
    }
    public String dueDate(){
	return dueDate;
    }
}
