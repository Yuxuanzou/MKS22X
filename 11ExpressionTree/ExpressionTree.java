public class ExpressionTree{
    private char op;
    private double value;
    private ExpressionTree left,right;
    
    /*TreeNodes are immutable, so no issues with linking them across multiple
     *  expressions. The can be constructed with a value, or operator and 2
     * sub-ExpressionTrees*/
    public ExpressionTree(double value){
	this.value = value;
	op = '~';
    }
    public ExpressionTree(char op,ExpressionTree l, ExpressionTree r){
	this.op = op;
	left = l;
	right = r;
    }
    
    public char getOp(){
	return op;
    }
    
    /* accessor method for Value, precondition is that isValue() is true.*/
    private double getValue(){
	return value;
    }
    /* accessor method for left, precondition is that isOp() is true.*/
    private ExpressionTree getLeft(){
	return left;
    }
    /* accessor method for right, precondition is that isOp() is true.*/
    private ExpressionTree getRight(){
	return right;
    }
    
    private boolean isOp(){
	return hasChildren();
    }
    private boolean isValue(){
	return !hasChildren();
    }
    
    private boolean hasChildren(){
	return left != null && right != null;
    }

    public String toString(){
	if (isValue()){
	    return (getValue() + "");
	}
	String l = getLeft().toString();
	String r = getRight().toString();
	return "(" + l + " " + getOp() + " " + r + ")";
    }

    public String toStringPostfix(){
	if (isValue()){
	    return (getValue() + " ");
	}
	String l = getLeft().toStringPostfix();
	String r = getRight().toStringPostfix();
	return l + r + getOp() + " ";
    }

    public String toStringPrefix(){
	if (isValue()){
	    return (getValue() + " ");
	}
	String l = getLeft().toStringPrefix();
	String r = getRight().toStringPrefix();
	return getOp() + " " + l + r;
    }

    public double evaluate(){
	if (isValue()){
	    return getValue();
	}
	else {
	    return apply(getOp(),getRight().evaluate(),getLeft().evaluate());
	}
    }

    private double apply(char op, double b, double a){
	if (op == '+'){
	    return a + b;
	}
	else if (op == '-'){
	    return a - b;
	}
	else if (op == '*'){
	    return a * b;
	}
	else if (op == '/'){
	    return a / b;
	}
	else {
	    return a % b;
	}
    }

    public static void main(String[] args){
    //ugly main sorry!
    ExpressionTree a = new ExpressionTree(4.0);
    ExpressionTree b = new ExpressionTree(2.0);

    ExpressionTree c = new ExpressionTree('+',a,b);
    System.out.println(c);
    System.out.println(c.toStringPostfix());
    System.out.println(c.toStringPrefix());
    System.out.println(c.evaluate());//6.0


    ExpressionTree d = new ExpressionTree('*',c,new ExpressionTree(3.5));
    System.out.println(d);
    System.out.println(d.toStringPostfix());
    System.out.println(d.toStringPrefix());
    System.out.println(d.evaluate());//21

    ExpressionTree ex = new ExpressionTree('-',d,new ExpressionTree(1.0));
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());//20

    ex = new ExpressionTree('+',new ExpressionTree(1.0),ex);
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());//21

    ex = new ExpressionTree('/',ex,new ExpressionTree(2.0));
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());//10.5   
  }
}
