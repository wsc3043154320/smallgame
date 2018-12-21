package cn.test.test;

public class CustomArrayList<E> {
	private Object[] elementData;
	private int size;
	public static final int DEFALT_CAPACITY=10;
	public CustomArrayList(){
		elementData=new Object[DEFALT_CAPACITY];
	}
	public CustomArrayList(int capacity) {
		elementData =new Object[capacity];
	}
	/**
	 * 
	 * @param element
	 */
	public void add(E element) {
		//Ê²Ã´Ê±ºòÀ©ÈÝ£º
		if(size==elementData.length) {
			//ÔõÃ´À©ÈÝ
			Object[] newArray =new Object[elementData.length+(elementData.length>>1)];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData =newArray;
		}
		elementData[size++]=element;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		
		return sb.toString();
	}
	public static void main(String[] args) {
		CustomArrayList ca= new CustomArrayList(20);
		
		for(char i='a';i<='z';i++) {
			ca.add(i);
		}
		System.out.println(ca);
	}
}
