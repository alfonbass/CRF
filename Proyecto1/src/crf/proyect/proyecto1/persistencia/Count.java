package crf.proyect.proyecto1.persistencia;

public class Count {
	private int id;
	private String name;
	private long money;
	
	public Count(int id,String name, long money){
		super();
		this.id=id;
		this.name=name;
		this.money=money;
	}
	
	public Count(){}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public long getMoney(){
		return money;
	}
	public void setMoney(long money){
		this.money=money;
	}
	

}
