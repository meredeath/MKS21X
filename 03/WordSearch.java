import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
    private char[][]data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;

    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows, int cols){
	data=new char[rows][cols];
	for(int i=0;i<rows;i++){
	    for(int g=0;g<cols;g++){
		data[i][g]='_';
	    }
	}
    }

    public WordSearch(int rows, int cols, String fileName){
	try{
	    data=new char[rows][cols];
	    for(int i=0;i<rows;i++){
		for(int g=0;g<cols;g++){
		    data[i][g]='_';
		}
	    }
	    wordsToAdd = new ArrayList<String>();
	    wordsAdded = new ArrayList<String>();
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);
	    while(in.hasNext()){
		String line = in.nextLine();
		wordsToAdd.add(line);
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: "+fileName);
	    System.exit(1);
	}
    }
    //public WordSearch(int rows, int cols, String fileName, int randSeed){
    //}

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
	for(int i=0;i<data.length;i++){
	    for(int g=0;g<data[0].length;g++){
		data[i][g]='_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String result = "";
	for(int i=0;i<data.length;i++){
	    for(int g=0;g<data[0].length;g++){
		result+="["+data[i][g]+"]";
	    }
	    result+="\n";
	}
	return result;
    }

    public boolean addWord(int r, int c, String word, int rowIncrement, int colIncrement){
	if(rowIncrement==0 && colIncrement==0){
	    return false;
	}else if(rowIncrement==0){
	    if(addWordHorizontal(word,r,c)){
		wordsToAdd.remove(word);
		wordsAdded.add(word);
		return true;
	    }else{
		return false;
	    }
	}else if(colIncrement==0){
		if(addWordVertical(word,r,c)){
		    wordsToAdd.remove(word);
		    wordsAdded.add(word);
		    return true;
		}else{
		    return false;
		}
	}else{
	    if(addWordDiagonal(word,r,c)){
		wordsToAdd.remove(word);
		wordsAdded.add(word);
		return true;
	    }else{
		return false;
	    }
	}
    }

    /**Attempts to add all words from wordsToAdd */
    public boolean addAllWords(){
	randgen = new Random();
	System.out.println(randgen.nextInt()%10);
	return true;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned 
     * and the board is NOT modified.
     */

    public boolean addWordHorizontal(String word,int row, int col){
	char[][] orig = data;
	if(word.length()+row>data[row].length){
	    return false;
	}
	int shorter = Math.min(data[row].length, word.length());
	for(int i=0;i<shorter;i++){
	    if((data[row][i+col]==('_')) ||
	       (word.charAt(i)==data[row][i+col])){
		data[row][i+col]=word.charAt(i);
	    }else{
		data=orig;
		return false;
	    }
	}
	return true;
    }
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */

    public boolean addWordVertical(String word, int row, int col){
	char[][] orig = data;
	if(word.length()+row>data.length){
	    return false;
	}
	for(int i=0;i<word.length();i++){
	    if((data[row+i][col]==('_')) ||
	       (word.charAt(i)==data[row+i][col])){
		data[row+i][col]=word.charAt(i);
	    }else{
		data=orig;
		return false;
	    }
	}
	return true;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left to bottom right, must fit on the WordGrid,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonal(String word,int row, int col){
	char[][] orig = data;
	if(word.length()+row>data[row].length||word.length()+row>data.length){
	    return false;
	}
	for(int i=0;i<word.length();i++){
	    if((data[row+i][col+i]==('_')) ||
	       (word.charAt(i)==data[row+i][col+i])){
		data[row+i][col+i]=word.charAt(i);
	    }else{
		data=orig;
		return false;
	    }
	}
	return true;
    }
}