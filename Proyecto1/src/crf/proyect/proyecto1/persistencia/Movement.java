package crf.proyect.proyecto1.persistencia;

public class Movement {
	private int id;
	private String type;
	private long cant;
	
	public Movement(int id,String type,long cant){
		this.id=id;
		this.type=type;
		this.cant=cant;
	}
	
	public Movement(){}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type=type;
	}
	
	public long getCant(){
		return cant;
	}
	public void setCant(long cant){
		this.cant=cant;
	}

}