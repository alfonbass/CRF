package crf.android.sql.persistencia;

public class Rol {
	
	private String name;
	private int level;
	private int xp;
	private int fr;
	private int mg;
	
	public Rol(int level,int xp,int fr,int mg){
		super();
		this.level=level;
		this.xp=xp;
		this.fr=fr;
		this.mg=mg;
	}
	public Rol() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}

	public int getLevel() {
		return level;
	}
	public void setLevel(int level){
		this.level=level;
	}
	
	public int getXp() {
		return xp;
	}
	public void setXp(int xp){
		this.xp=xp;
	}
	
	public int getFr() {
		return fr;
	}
	public void setFr(int fr){
		this.fr=fr;
	}
	
	public int getMg() {
		return mg;
	}
	public void setMg(int mg){
		this.mg=mg;
	}
}