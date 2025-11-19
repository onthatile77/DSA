package myproject;
/*
 * STACK: SO ADD&REMOVE AT THE END
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class MyStackAsArrayList<E>{

	private MyArrayList<E> theStack;
	
	public MyStackAsArrayList()
	{
		theStack = new MyArrayList<>();
	}
	
	@SuppressWarnings("unchecked")
	public void push(Object e)
	{
		if(theStack.checkSpace())
		{
			theStack.add(theStack.size(), (E)e);
		}
		else
		{
			throw new IndexOutOfBoundsException("Stack already full: size = " + theStack.size());
		}
	}
	
	public E pop()
	{
		if(theStack.size() == 0)
		{
			throw new IndexOutOfBoundsException("Stack empty");
		}
		
		E hold = theStack.remove(theStack.size()-1);
		return hold;
		
	}
	
	public String peek()
	{
		String result = "";
		if (theStack.size() != 0)
		{
			result += theStack.get(theStack.size()-1);
		}
		
		return result;
	}
	
	public String toString()
	{
		
		return theStack.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStackAsArrayList<Integer> list = new MyStackAsArrayList<>();
		
		System.out.println("ARRAY LIST STACK = TAIL / INDEX=SIZE/SIZE-1");
		
		list.push(new Integer(7));
		list.push(new Integer(9));
		list.push(new Integer(3));
		list.push(new Integer(6));
		//System.out.println(list.toString());
		list.push(new Integer(10));
		System.out.println(list.toString());
		
		String peeked = list.peek();
		System.out.println("Peeking " + peeked + "\n");
		
		Integer popped = list.pop();
		
		System.out.println("Popped " + popped + "\n"+list.toString());
		String peeked2 = list.peek();
		System.out.println("Peeking " + peeked2 + "\n");
	}
	
}
