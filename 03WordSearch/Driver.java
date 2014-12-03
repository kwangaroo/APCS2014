public class Driver{
    public static void main(String[]args) throws FileNotFoundException{
	WordGrid a = new WordGrid(20, 15);
	a.loadWordsFromFile("words.txt", true);
	System.out.println("Find these words:\n" + a.wordsInPuzzle+"\n\n" + a);

    }
}
