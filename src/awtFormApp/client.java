package awtFormApp;

public class client {
	public int id;
	public String name, address, hobies, gender, lang, choice;
	public client(int id, String name, String addresse, String hobb, String gender, String lang, String choice) {
		this.id = id;
		this.name = name;
		this.address = addresse;
		this.hobies = hobb;
		this.gender = gender;
		this.lang = lang;
		this.choice = choice;
	}
	@Override
	public String toString() {
		return "client number "+id+", name: "+name+", address: "+address+", hobies: "+hobies+", gender: "+gender+", lang: "+lang+", choice: "+choice+"\n";
	}
}
