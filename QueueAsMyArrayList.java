package myproject;

/*
 * Array Queue: Add at End, Remove at start
 * 
 * 
 * 
 */

public class QueueAsMyArrayList<E> {
	
	private MyArrayList<E> qArr;
	
	public QueueAsMyArrayList()
	{
		qArr = new MyArrayList<>();
	}
	
	public void enqueue(E e)
	{
		if(!qArr.checkSpace())
		{
			return;
		}
		qArr.add(qArr.size(), e);
		
	}
	
	public E dequeue()
	{
		if(qArr.size() == 0)
		{
			return null;
		}
		
		E hold = qArr.remove(0);
		
		return hold;
	}
	
	public String toString()
	{
		return qArr.toString();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueAsMyArrayList<Integer> list = new QueueAsMyArrayList<>();
		System.out.println(list.toString());
		Integer tmp = list.dequeue();
		System.out.println("TMP:" + tmp + "\n"+list.toString());
		list.enqueue(7);
		System.out.println(list.toString());
		list.dequeue();
		System.out.println(list.toString());
		list.enqueue(7);
		System.out.println(list.toString());
		list.enqueue(9);
		System.out.println(list.toString());
		list.enqueue(21);
		System.out.println(list.toString());
		list.dequeue();
		System.out.println(list.toString());
		list.enqueue(15);
		System.out.println(list.toString());
		list.enqueue(11);
		System.out.println(list.toString());
		
		
		
	}

}
