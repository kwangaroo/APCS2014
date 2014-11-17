import java.util.*;
public class ArrayListMethods {
    public static void removeDuplicates(ArrayList <Integer> A) {
    
	int j = 0;
	int i = 1;
	
	while (i < A.size()) {
	    if (A.get(i) == A.get(j)) {
	        i++;
	    } else {
	        j++;
	        A.set(j, A.get(i));
	        i++;
	        }
	}
	
	for(int k = j; k > 1; k--){
	    A.remove(A.size() - k);
	}
    }

    public static void main(String[] args) {
	ArrayList<Integer>arr;
	arr = new ArrayList(6);
	arr.add(2);
	arr.add(3);
	arr.add(3);
	arr.add(102920);
	arr.add(30);
	arr.add(30);
	removeDuplicates(arr);
	System.out.println(arr);
    }
}
