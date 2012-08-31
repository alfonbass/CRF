package crf.proyect.proyecto1.persistencia;

public class Movement {
	private int id;
	private int id_cuenta;
	private int id_categoria;
	private String type;
	private long cant;
	
	public Movement(int id,int id_cuenta,int id_categoria,String type,long cant){
		this.id=id;
		this.id_cuenta=id_cuenta;
		this.id_categoria=id_categoria;
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
	
	public int getId_Cuenta(){
		return id_cuenta;
	}
	public void setId_Cuenta(int id_cuenta){
		this.id_cuenta=id_cuenta;
	}
	public int getId_Categoria(){
		return id_categoria;
	}
	public void setId_Categoria(int id_categoria){
		this.id_categoria=id_categoria;
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