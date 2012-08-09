package crf.proyect.proyecto1.persistencia;

public class Count {
	private String name;
	private long money;
	
	public Count(String name, long money){
		super();
		this.name=name;
		this.money=money;
	}
	
	public Count(){}
	
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
