import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
    public static void main(String[] args){
	if(args.length<2){
	    System.out.println("you have to give at least a row and col specification to run the program");
	}
	if(args.length==2){
	    WordSearch a = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	    System.out.println(a);
	}
	if(args.length==3){
	    WordSearch a = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
	    a.addAllWords();
	    a.fillGaps();
	    System.out.println(a);
	}
	if(args.length==4){
	    WordSearch a = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
	    a.addAllWords(Integer.parseInt(args[3]));
	    a.fillGaps(Integer.parseInt(args[3]));
	    System.out.println(a);
	}
	if(args.length==5){
	    WordSearch a = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
	    a.addAllWords(Integer.parseInt(args[3]));
	    System.out.println(a);
	}
    }
    private char[][]data;
    private char[][]answers;
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
    /*
    public WordSearch(int rows, int cols, String fileName, int randSeed){
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
	    seed=randSeed;
	}catch(FileNotFoundException e){
	    System.out.println("File not found: "+fileName);
	    System.exit(1);
	}
    }
    */

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
	}
	if(rowIncrement==0){
	    if(addWordHorizontal(word,r,c,colIncrement)){
		wordsToAdd.remove(word);
		wordsAdded.add(word);
		return true;
	    }else{
		return false;
	    }
	}
	if(colIncrement==0){
	    if(addWordVertical(word,r,c,rowIncrement)){
		wordsToAdd.remove(word);
		wordsAdded.add(word);
		return true;
	    }else{
		return false;
	    }
	}
	if(addWordDiagonal(word,r,c,rowIncrement,colIncrement)){
	    wordsToAdd.remove(word);
	    wordsAdded.add(word);
	    return true;
	}else{
	    return false;
	    }
    }

    /**Attempts to add all words from wordsToAdd */
    public boolean addAllWords(int s){
	randgen = new Random(s);
	boolean shouldStop = false;
	while(wordsToAdd.size()>0){
	    //System.out.println(wordsToAdd);
	    if(shouldStop==true){
		shouldStop=false;
	    }
	    for(int i=0;i<1000 && !shouldStop;i++){
		int row = randgen.nextInt(data.length-1);
		//System.out.println(row);
		int col = randgen.nextInt(data[0].length-1);
		//System.out.println(col);
		String w = wordsToAdd.get(0);
		//System.out.println(w);
		int rInc=randgen.nextInt()%2;
		//System.out.println(rInc);
		int cInc=randgen.nextInt()%2;
		//System.out.println(cInc);
		//System.out.println(addWord(row,col,w,rInc,cInc));
		shouldStop=addWord(row,col,w,rInc,cInc);
		if(i==999){
		    return false;
		}
	    }
	}
	answers=data;
	return wordsToAdd.size()==0;
    }

    /**Attempts to add all words from wordsToAdd */
    public boolean addAllWords(){
	randgen = new Random();
	boolean shouldStop = false;
	while(wordsToAdd.size()>0){
	    //System.out.println(wordsToAdd);
	    if(shouldStop==true){
		shouldStop=false;
	    }
	    for(int i=0;i<1000 && !shouldStop;i++){
		int row = randgen.nextInt(data.length-1);
		//System.out.println(row);
		int col = randgen.nextInt(data[0].length-1);
		//System.out.println(col);
		String w = wordsToAdd.get(0);
		//System.out.println(w);
		int rInc=randgen.nextInt()%2;
		//System.out.println(rInc);
		int cInc=randgen.nextInt()%2;
		//System.out.println(cInc);
		//System.out.println(addWord(row,col,w,rInc,cInc));
		shouldStop=addWord(row,col,w,rInc,cInc);
		if(i==999){
		    return false;
		}
	    }
	}
	answers=data;
	return wordsToAdd.size()==0;
    }

    /**Fills in all the gaps after words are added */
    public void fillGaps(int s){
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	int len = alphabet.length();
	randgen = new Random(s);
	for(int i=0;i<data.length;i++){
	    for(int g=0;g<data[0].length;g++){
		data[i][g]=alphabet.charAt(randgen.nextInt(len));
	    }
	}
    }

    /**Fills in all the gaps after words are added */
    public void fillGaps(){
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	int len = alphabet.length();
	randgen = new Random();
	for(int i=0;i<data.length;i++){
	    for(int g=0;g<data[0].length;g++){
		data[i][g]=alphabet.charAt(randgen.nextInt(len));
	    }
	}
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

    public boolean addWordHorizontal(String word, int row, int col, int inc){
	char[][] orig = data;
	if(col>data[0].length || row>data.length){
	    return false;
	}
	if(inc==1){
	    if(word.length()+col>data[row].length){
		return false;
	    }
	    for(int i=0;i<word.length();i++){
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
	if(inc==-1){
	    if(col+1<word.length()){
		return false;
	    }
	    for(int i=0;i<word.length();i++){
		if((data[row][col-i]==('_')) ||
		   (word.charAt(i)==data[row][col-i])){
		    data[row][col-i]=word.charAt(i);
		}else{
		    data=orig;
		    return false;
		}
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

    public boolean addWordVertical(String word, int row, int col, int inc){
	char[][] orig = data;
	if(col>data[0].length || row>data.length){
	    return false;
	}
	if(inc==1){
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
	if(inc==-1){
	    if(row+1<word.length()){
		return false;
	    }
	    for(int i=0;i<word.length();i++){
		if((data[row-i][col]==('_')) ||
		   (word.charAt(i)==data[row-i][col])){
		    data[row-i][col]=word.charAt(i);
		}else{
		    data=orig;
		    return false;
		}
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
    public boolean addWordDiagonal(String word,int row, int col, int rowInc, int colInc){
	char[][] orig = data;
	if(rowInc!=colInc){
	    return false;
	}
	if(rowInc==1){
	    if(word.length()+col>data[row].length||word.length()+row>data.length){
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
	if(rowInc==-1){
	    if((row+1<word.length()) ||
	       (col+1<word.length())){
		return false;
	    }
	    for(int i=0;i<word.length();i++){
		if(data[row-i][col-i]==('_') ||
		   (word.charAt(i)==data[row-i][col-i])){
		    data[row-i][col-i]=word.charAt(i);
		}else{
		    data=orig;
		    return false;
		}
	    }
	}
	return true;
    }
	    
}