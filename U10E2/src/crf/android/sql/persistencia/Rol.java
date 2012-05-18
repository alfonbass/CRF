package crf.android.sql.persistencia;

public class Rol {
	private int id;
	private String name;
	private int level;
	private int xp;
	private int vd;
	private int fr;
	private int df;
	private int mg;
	
	public Rol(int id,String name,int level,int xp,int vd,int fr,int df,int mg){
		super();
		this.id=id;
		this.name=name;
		this.level=level;
		this.xp=xp;
		this.vd=vd;
		this.fr=fr;
		this.df=df;
		this.mg=mg;
	}
	public Rol() {
		
	}
	//..................
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	//...................
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	//.................
	public int getLevel() {
		return level;
	}
	public void setLevel(int level){
		this.level=level;
	}
	//....................
	public int getXp() {
		return xp;
	}
	public void setXp(int xp){
		this.xp=xp;
	}
	//.......................
	public int getVd(){
		return vd;
	}
	public void setVd(int vd){
		this.vd=vd;
	}
	//.....................
	public int getFr() {
		return fr;
	}
	public void setFr(int fr){
		this.fr=fr;
	}
	//....................
	public int getDf(){
		return df;
	}
	public void setDf(int df){
		this.df=df;
	}
	//......................
	public int getMg() {
		return mg;
	}
	public void setMg(int mg){
		this.mg=mg;
	}
}