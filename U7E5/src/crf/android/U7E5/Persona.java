package crf.android.U7E5;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
	String nombre = "";
	String apellido = "";
	String pais = "";
	int edad = 1;
	String genero = "";
	Boolean trabajador = false;
	
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public void setApellido(String apellido){
		this.apellido=apellido;
	}
	public String getPais(){
		return pais;
	}
	public void setPais(String pais){
		this.pais=pais;
	}
	public Integer getEdad (){
		return edad;
	}
	public void setEdad (int edad){
		this.edad=edad;
	}
	public String getGenero(){
		return genero;
	}
	public void setGenero(String genero){
		this.genero=genero;
	}
	public boolean getTrabajador(){
		return trabajador;
	}
	public boolean setTrabajador(boolean trabajador){
		return this.trabajador=trabajador;
	}
	
	public Persona(Parcel in) {
		this();
		readToParcel(in);
    }

	public Persona() {
		
	}
	public int describeContents() {
		return 0;
	}
	
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(nombre);
		dest.writeString(apellido);
		dest.writeString(pais);
		dest.writeInt(edad);
		dest.writeString(genero);
		dest.writeString(String.valueOf(trabajador));
	}
	
	public void readToParcel(Parcel parcel){
		nombre = parcel.readString();
		apellido = parcel.readString();
		pais = parcel.readString();
		edad = parcel.readInt();
		genero = parcel.readString();
		String trabajador = parcel.readString();
		if (trabajador.equals("true"))
			this.trabajador = true;
		else 
			this.trabajador = false;
	}
	
	public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {
		public Persona createFromParcel(Parcel in){
			return new Persona(in);
		}
		
		public Persona[] newArray(int size) {
			return new Persona[size];
		}
	};
}