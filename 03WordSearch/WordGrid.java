import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;

public class WordGrid{
    private char[][]data;
    private File wordList = new File("words.txt");
    private Scanner s = new Scanner(wordList);
    private ArrayList<String> words = new ArrayList<String>;
    private int rows;
    private int cols;
    private Random r = new Random;
    private boolean answers;
    private ArrayList<String>wordsIn = new ArrayList<String>;

    public WordGrid(int row, int col, int randomSeed, int answers){
	data = new char[row][col];
	clear();
	rows = row;
	cols = col;
	random.setSeed(randomSeed);
	if(answers == 1){
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

    public void createWords(File wordList){
	int lineCount = 0;
	while(s.hasNextLine()){
	    String line = s.nextLine();
	    words.append(line);
	    lineCount++;
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
		if(data[row + dx * i][col + dy * i]!=" "){
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

    public String wordsInPuzzle(){
	String fin = "";
	for(int i=0;i<wordsIn.length/3;i+=3){
	    for(int j=0;j<3;j++){
		fin+=wordsIn[i+j] + "\t";
	    }
	    fin+="\n";
	}
	return fin;
    }


    public void fillIn(){
	Random r = new Random();
	if(answers){
	    for (int i=0;i<data.length;i++){
		for (int j=0;j<data[i].length;j++){
		    if (data[i][j]==' '){
			data[i][j]=(char)(r.nextInt((90-65)+1)+65);
		    }
		}
	    }
	}
    }
		    
    public static void main(String[]args){
	WordGrid test = new WordGrid(10, 10); 
	test.addWordH("dog", 2, 4);
	test.toString();
	test.clear();
	test.addWordBwH("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 0, 0);
    }
}
