package myproject;

public class QueueAsMyLinkedList<E> {

	private MyLinkedList<E> qLink;
	
	public QueueAsMyLinkedList()
	{
		qLink = new MyLinkedList<>();
	}
	
	public void enqueue(E e)
	{//add at end
		qLink.append(e);
	}
	
	public E dequeue()
	{
		E hold = qLink.getFirst();
		
		if(hold != null)
		{
			qLink.removeFirst();
		}
		
		return hold;
	}
	
	
	public String toString()
	{
		return qLink.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueAsMyLinkedList<Integer> list = new QueueAsMyLinkedList<>();
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
