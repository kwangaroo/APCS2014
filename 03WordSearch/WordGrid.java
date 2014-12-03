import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;

public class WordGrid{
    private char[][]data;
    private ArrayList<String> words = new ArrayList<String>();
    private int rows;
    private int cols;
    private Random r = new Random();
    private boolean answers;
    private ArrayList<String>wordsIn = new ArrayList<String>();

    public WordGrid(int row, int col, int randomSeed, int ans){
	data = new char[row][col];
	clear();
	rows = row;
	cols = col;
	r.setSeed(randomSeed);
	if(ans == 1){
	    answers = false;
	}else{
	    answers = true;
	}
    }

    public WordGrid(int row, int col){
	this(row,col,r.nextInt(Integer.MAX_VALUE),0);
    }

    public void setSeed(int n){
	r = new Random(n);
    }

    public void loadWordsFromFile(String fileName, boolean fillRandomLetters){
	File wordList = new File(fileName);
	Scanner s = new Scanner(wordList);
	int lineCount = 0;
	while(s.hasNextLine()){
	    String line = s.nextLine();
	    words.add(line);
	    lineCount++;
	}
	loadWords();
	if(fillRandomLetters){
	    fillIn();
	}
    }

    public void clear(){
	for (int j=0;j<cols;j++){
	    for (int i=0;i<rows;i++){
		data[j][i] = ' ';
	    }
	}
    }

    public String toString(){
	String fin = "";
	for (int j=0;j<cols;j++){
	    for (int i=0;i<rows - 1;i++){
		fin+= data[j][i] + " ";
	    }
	    fin+= data[j][rows] + "\n";
	}
	return fin;
    }

    public boolean validValue(int row, int col){
	if (row >= rows || col >= cols || row < 0 || col < 0) return false;
	return true;
    }

    public boolean doesFit(String word, int row, int col, int dx, int dy){
	int totalXcor = row + word.length() * dx;
	int totalYcor = col + word.length() * dy;
	if(totalXcor > 0 && totalXcor < rows && totalYcor < cols && totalYcor > 0){ 
	    return true;
	}
	return false;
    }

    public boolean isBlank(String word, int row, int col, int dx, int dy){
	if(doesFit(word, row, col, dx, dy)){
	    for(int i=word.length();i>0;i--){
		if(data[row + dx * i][col + dy * i]!=' '){
		    return false;
		}
	    }
	    return true;
	}
    }

    public boolean addWord(String word, int row, int col, int dx, int dy){
	if(dx != 0 || dy !=0){
	    if(validValue(row, col) && doesFit(word, row, col, dx, dy) && isBlank(word, row, col, dx, dy)){
		for(int i=0; i<word.length();i++){
		    data[row+(dx*i)][col+(dy*i)] = word.charAt(i);
		}
		wordsIn.add(word);
		return true;
	    }
	}
	return false;
    }

    public void loadWords(){
	for(int i=0;i<words.size();i++){
	    addWord(words.get(i), r.nextInt(rows), r.nextInt(cols), r.nextInt(1)-1, r.nextInt(1)-1);
	}
    }

    public String wordsInPuzzle(){
	String fin = "";
	for(int i=0;i<wordsIn.size()/3;i+=3){
	    for(int j=0;j<3;j++){
		fin+=wordsIn.get(i+j) + "\t";
	    }
	    fin+="\n";
	}
	return fin;
    }


    public void fillIn(){
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[i].length;j++){
		if (data[i][j]==' '){
		    data[i][j]=(char)(r.nextInt((90-65)+1)+65);
		}
	    }
	}
    }

		   
}
