public class Sorts{
    private int[]list;
    
    public Sorts(int[]a){
    	test = a;
    }
    
    public static void insertionSort() {
        for (int i = 1; i < list.length; i++) {
            int next = list[i];
	    int j = i;
            while (j > 0 && list[j - 1] > next) {
                list[j] = list[j - 1];
                j--;
            }
	    list[j] = next;
        }
    }
	
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void selectionSort() {
        for (int i = 0; i < list.length - 1; i++) {
	    int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            swap(list, minPos, i);
        }
    }
    
    public static void bubbleSort(){
        int temp;
        for (int i=0;i<list.length;i++) {
	    for(int j = 0; j < list.length; j++){
		if(list[i] > list[j + 1]) {
		    temp = list[j+1];
		    list[j+1] = list[i];
		    list[i] = temp;
		}
	    }
        }
    }
    
}
