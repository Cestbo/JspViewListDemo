package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;



//购物车类
public class Cart {

	private HashMap<Items, Integer> goods;//商品列表《商品项，商品数量》
	private double totalPrice;//总价格

	
	public Cart() {
		// TODO Auto-generated constructor stub
	
		goods=new HashMap<Items,Integer>();
		totalPrice=0.0;
	}
	
	public HashMap<Items, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public boolean addGoods(Items item,int num) {
		
		  if(goods.containsKey(item))
		  {
			  goods.put(item, goods.get(item)+num);
		  }
		  else
		  {
			  goods.put(item, num);
		  }
			
		    calTotalPrice();
			return true;
		   
	}
	
	public boolean removeGoods(Items item) {
		
		if(goods.remove(item)!=null)
		{
			calTotalPrice();
			return true;
		}
		return false;
		
	}
	
	public double calTotalPrice() {
		
		double sum=0.0;
		Set<Items> keys=goods.keySet();
//		Iterator<Items> it=keys.iterator();
//		while(it.hasNext())
//		{
//			Items items=it.next();
//			sum=sum+items.getPrice()*goods.get(items);
//		}
		for(Items i:keys)
		{
			sum=sum+i.getPrice()*goods.get(i);
		}
		setTotalPrice(sum);
		return sum;
	}

	public static void main(String[] args) {
		
		Items i1=new Items();
		Items i2=new Items();
		i1.setName("i1");
		i2.setName("i2");
		i1.setPrice(100);
		i2.setPrice(100);
		Items i3=new Items();
		i3.setName("i1");
		i3.setPrice(100);
		Cart cart=new Cart();
		cart.addGoods(i1, 2);
		cart.addGoods(i2, 1);
		cart.addGoods(i3, 2);
		if(!cart.addGoods(i2, 1))
			System.out.println("fail");
		System.out.println(cart.getTotalPrice());
		//cart.removeGoods(i2);
		Set<Map.Entry<Items, Integer>> all=cart.getGoods().entrySet();
		for(Map.Entry<Items, Integer> obj:all)
		{
			System.out.println(obj);
		}
		System.out.println(cart.getTotalPrice());
		System.out.println(cart.hashCode());
	}
}
