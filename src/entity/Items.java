package entity;

public class Items {

	private int no;//��Ʒ��̖
	private String name;
	private int price;
	private int number;//���
	private String city;//���ڵ�
	private String picture;
    
	public Items() {
		// TODO Auto-generated constructor stub
	    no=0;
	    name=null;
	    price=0;
	    number=0;
	    city=null;
	    picture=null;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return no+name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
		{
			return true;
		}
		if(obj instanceof Items)
		{
			Items items=(Items)obj;
			if(no==items.getNo()&&name.equals(items.getName()))
			{
				return true;
			}
		}
		
		return false;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return name+","+price+",";
	}
}
