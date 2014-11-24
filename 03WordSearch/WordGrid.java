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

    public WordGrid(int row, int col){
	data = new char[row][col];
	clear();
	rows = row;
	cols = col;
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

    public boolean addWordH(String word, int row, int col){
	if (validValue(row, col) && col + word.length() < cols){
	    for(int i = 0;i<word.length();i++){
		data[row][cols+i] = word.charAt(i);
		return true;
	    }
	}
	return false;
    }

    public boolean addWordBwH(String word, int row, int col){
	if (validValue(row, col) && col - word.length() > 0){
	    for (int i = 0; i<word.length(); i++){ 
	    data[row][cols - i] = word.charAt(i);
	    }
	    return true;
	}
	return false;
    }

    public static void main(String[]args){
	WordGrid test = new WordGrid(10, 10); 
	test.addWordH("dog", 2, 4);
	test.toString();
	test.clear();
	test.addWordBwH("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 0, 0);
    }
}
