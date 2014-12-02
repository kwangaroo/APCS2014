public class OrderedSuperArray extends SuperArray{ 
  private String[]arr;
    
  public OrderedSuperArray(String[]a){
  	a = arr;
  }
    
  public String add(String e){
	super.resize(arr.length+1);
	  for(int i=0;i<arr.length-1;i++){
	    if(arr[i].compareTo(e) > 0 && arr[i+1].compareTo(e) < 0){
		    super.addIn(i+1,e);
	    }
	    return e;
	  }
  }
    
  public String set(int index, String e){
	super.remove(arr[index]);
	add(e);
	return e; 
  }
}
