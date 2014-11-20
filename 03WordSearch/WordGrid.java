import java.util.*; 
public class WordGrid{
    private char[][]data;

    public WordGrid(int rows, int cols){
	data = new char[rows][cols];
	clear();
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

    public void addWordH(String word, int row, int col){
	if (row !> rows && col !> cols && col + word.length() < cols){
	    for(int i = 0;i<word.length();i++){
		data[row][cols+i] = word.charAt(i);
	    }
	}
    }

    public void addWordBwH(String word, int row, int col){
	if (row !> rows && col !> cols && col - word.length() > 0){
	    for (int i = 0; i<word.length(); i++){ 
	    data[row][cols - i] = word.charAt(i);
	    }
	}
    }

}
