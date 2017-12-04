public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String isbn, String callNumber){
	super(author,title,isbn,callNumber);
	currentHolder=null;
	dueDate=null;
    }

    public String getCurrentHolder(){
	return currentHolder;
    }
    public String getDueDate(){
	return dueDate;
    }
    public void setCurrentHolder(String ch){
	currentHolder=ch;
    }
    public void setDueDate(String dd){
	dueDate=dd;
    }

    public void checkout(String person, String date){
	currentHolder=person;
	dueDate=date;
    }
    public void returned(){
	currentHolder=null;
	dueDate=null;
    }
    public String circulationStatus(){
	if(currentHolder==null){
	    return "book availible on shelves";
	}else{
	    return "Current Holder: "+currentHolder+
		" Due Date: "+dueDate;
	}
    }
    public String toString(){
	return super.toString()+
	    " Current Holder: "+currentHolder+
	    " Due Date: "+dueDate;
    }
}
