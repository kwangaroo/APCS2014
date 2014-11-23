import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;

public class WordGrid{
    private char[][]data;
    File wordList = new File("words.txt");
    Scanner s = new Scanner();
    ArrayList<String> words;

    public WordGrid(int rows, int cols){
	data = new char[rows][cols];
	clear();
    }

    public void createWords(File wordList){
	int lineCount = 0;
	while(s.hasNextLine()){
	    String line = s.nextLine();
	    words.add(line);
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
