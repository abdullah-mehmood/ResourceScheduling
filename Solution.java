import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<MyClass> mylist = new ArrayList<>();
        
        for(int i = 0; i< n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt(); 
            MyClass myClass = new MyClass();
            myClass.sets(a);
            myClass.setf(b);
            
            mylist.add(myClass);
           
        }
    
            int result = myOutputfun(n, mylist); 
            
            System.out.print(result);
        
       
    }
    
    
    public static int myOutputfun(int size, ArrayList<MyClass> list){
        
        Collections.sort(list, new Comparator<MyClass>() {
            public int compare(MyClass o1, MyClass o2){
                return o1.gets() - o2.gets();
            }
        });
        
        ArrayList<MyClass> mylist = new ArrayList<>();
        
        if(!list.isEmpty() && mylist.isEmpty()){
            mylist.add(new MyClass(list.get(0).gets(), list.get(0).getf() ));
        }
        
        for(int i = 1; i<list.size(); i++){
            
            if(mylist.get(mylist.size() - 1).getf() <= list.get(i).gets()){
                mylist.add(new MyClass(list.get(i).gets(), list.get(i).getf()));
            }
        }
            
        
        return mylist.size();      
    }
    
    
   
public static class MyClass{
    
    public int s;
    public int f;
    
    public MyClass(){}
    public MyClass(int s, int f){
        this.s = s;
        this.f = f;
    }
    
    public int gets(){
        return s;
    }
    public int getf(){
        return f;
    }
    
    public void sets(int s){
        this.s = s;
    }
    public void setf(int f){
        this.f = f;
    }
}
}
