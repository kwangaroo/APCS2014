public class SuperArray{
    private String[]initial;
    private int saveCount; 

    public SuperArray(){
	initial = new String[10];
    }

    public SuperArray(int size){
	initial = new String[size];
    }

    public void setArray(String[]i){
	initial = i;
    }

    public String toString(){
	String finstring = "";
	for(int i = 0; i < size(); i++){
	    finstring+= initial[i] + " ";
	}
	return "[ " + finstring + "]";
    }

    public void resize(int newCapacity){
	String[]fin;
      fin = new String[newCapacity];
	for(int i=0; i<newCapacity && i<initial.length;i++){
	    fin[i] = initial[i];
	}
	initial = fin; 
    }

    public int size(){
	return initial.length;
    }

    public void add(String e){
	resize(initial.length+1);
	initial[initial.length-1] = e;
    }

    public void addIn(int index, String o){
	String[]fin;
	fin = new String[size()+1];
	for (int i = 0; i < index; i++){
	    fin[i] = initial[i];
	}

	fin[index] = o;

	for (int j = index+1; j < fin.length; j++){
	    fin[j] = initial[j-1];
	}
	initial = fin;
    }

    public static void insertionSort() {
        for (int i = 1; i < initial.length; i++) {
            String next = initial[i];
	    int j = i;
            while (j > 0 && initial[j - 1] > next) {
                initial[j] = initial[j - 1];
                j--;
            }
	    initial[j] = next;
        }
    }
    
    public int find(String target){
	for(int i = 0; i < initial.length(); i++){
	    if(initial[i].equals(target)){
		return i; 
	    }
	}
	return -1;
    }

}
