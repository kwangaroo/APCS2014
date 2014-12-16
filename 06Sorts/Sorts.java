public class Sorts{
    private int[]test;
    
    public Sorts(int[]a){
    	test = a;
    }
    
    public void insertionSort(){
    	int sv = 0;
    	int sav = 0;
    	for(int i=1;i<size();i++){
	    sv = initial[i];
	    for(int j=i;j>0;j--){
	    	if(initial[j].compareTo(sv) < 0){
		    initial[j] = sav;  
		    set(j, sv);
		    add(sav);
		    j = 0;
		}
	    }
	} 
    }
    
}
