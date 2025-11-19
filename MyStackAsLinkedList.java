package myproject;
/*
 * STACK_LINKED: OPPOSITE TO ARRAY, ADD AND DELETE FROM HEAD, I THINK COZ NO NEED TO UPDATE NULL IF USING TAIL
 * 
 */

public class MyStackAsLinkedList<E> {
	private MyLinkedList<E> theLStack;
	public MyStackAsLinkedList()
	{
		theLStack = new MyLinkedList<>();
	}
	
	public void push(E e)
	{
		theLStack.prepend(e);
	}
	
	public E pop()//use delete
	{
		E hold = theLStack.getFirst();
		
		if (hold != null)
		{
			theLStack.delete(0);
			
		}
		
		return hold;
		
		
		
	}
	
	public String peek()
	{
		String result = "";
		if(theLStack.getFirst() != null)
		{
			result += theLStack.getFirst();
		}
		return result;
	}

	public String toString()
	{
		return theLStack.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStackAsLinkedList<Integer> list = new MyStackAsLinkedList<>();
		
		System.out.println("LINKED LIST STACK = HEAD");
		
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
