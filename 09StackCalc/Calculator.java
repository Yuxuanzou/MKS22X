import java.util.LinkedList;
import java.util.*;

public class Calculator{
    //evaluation
    public static double eval(String value){
        String[] values = value.split(" ");
	Stack<Double> a = new Stack<Double>();
	if (values.length == 1){
	    return Double.parseDouble(values[0]);
	}
	for (String x : values){
	    if (checkOperator(x)){
		a.push(calculate(a.pop(),a.pop(),x));
	    }
	    else{
		a.push(Double.parseDouble(x));
	    }
	}
	return a.peek();
    }

    public static double calculate(double second,double first, String operator){
	if (operator.equals("+")){
	    return first + second;
	}
	else if (operator.equals("-")){
	    return first - second;
	}
	else if (operator.equals("*")){
	    return first * second;
	}
	else if (operator.equals("/")){
	    return first / second;
	}
	else {
	    return first % second;
	}
    }

    //stack class
    public static class Stack<T> extends LinkedList<T>{
	//add to top stack
	public void push(T value){
	    add(value);
	}
	
	//remove the top stack
	public T pop(){
	    return remove(size() - 1);
	}
	
	//cheat code
	public T peek(){
	    return get(size() - 1);
	}
    }

    //check if is operator
    public static boolean checkOperator(String value){
	String str = "+-*/%";
	return str.contains(value);
    }

    /*
    public static void main(String[] args){
	String str = "10 3 / 3 *";
	System.out.println(StackCalc.eval(str));
    }
    */
}
