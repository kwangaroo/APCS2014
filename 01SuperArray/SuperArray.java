public class SuperArray{
    private Object[]initial;
    private int saveCount; 

    public static void main(String[]args){
	superArray(5);
	setArray(Integer[1,5,3,48,9]);
	toString();
	resize(6);
	add(7);
	add(4, 39);
	set(0,95);
	remove(2);
	get(3);
	toString();
	System.out.println("\nExpected: [95, 5, 39, 9, null, 7]");
	clear();
	toString();
    }

    public superArray(){
	initial = new Object[10];
    }

    public superArray(int size){
	initial = new Object[size];
    }

    public void setArray(Object[]i){
	initial = i;
    }

    public void toString(){
	String finstring = "";
	for(int i = 0; i < size(); i++){
	    finstring+= initial[i] + " ";
	}
	System.out.println("[ " + finstring + "]");
    }

    public void resize(int newCapacity){
	fin = new Object[newCapacity];
	for(int i=0; i<newCapacity && i<initial.length;i++){
	    fin[i] = initial[i];
	}
	initial = fin; 
    }

    public int size(){
	return initial.length;
    }

    public void add(Object e){
	resize(initial.length+1);
	initial[initial.length-1] = e;
    }

    public void add(int index, Object o){
	Object[]fin;
	fin = new Object[size()+1];
	for (int i = 0; i < index; i++){
	    fin[i] = initial[i];
	}

	fin[index] = o;

	for (int j = index+1; j < fin.length; j++){
	    fin[j] = initial[j-1];
	}
	initial = fin;
    }
   
    public void clear(){
	initial = new Object[size()];
    }

    public Object get(int index){
	if (index >= size() || index < 0){
	    System.out.println("You can't just do that.");
	    return null;
	}
	return initial[index];
    }

    public Object set(int index, Object e){
	if (index >= size() || index < 0){
	    System.out.println("You can't just do that");
	    return null;
	}
	initial[index] = e; 
	return e;
    }

    public Object remove(int index){
	Object[]fina;
	fina = new Object[size() - 1];
	if (index >= size() || index < 0){
	    System.out.println("Consider changing that index.");
	    return null;
	}
	for(int i = 0; i < index; i++){
	    fina[i] = initial[i];
	}
	for(int i = index; i < size()-1; i++){
	    fina[i] = initial[i+1];
	}
	initial = fin; 
	resize(size()-1);
	return initial[index];
    }
}
