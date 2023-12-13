package Zoo;

import java.util.ArrayList;

public class ZOO {


protected ArrayList<Animal> animales;

protected ArrayList<Trabajador> trabajadores;

protected ArrayList<Visitante> visitantes;

public ArrayList<Animal> getAnimales() {

	return animales;

}

public void setAnimales(ArrayList<Animal> animales) {

this.animales = animales;

}

public ArrayList<Trabajador> getTrabajadores() {

	return trabajadores;

}

public void setTrabajadores(ArrayList<Trabajador> trabajadores) {

	this.trabajadores = trabajadores;

}

public ArrayList<Visitante> getVisitantes() {
	// Por aquí vamos a empezar a crear unos visitantes:
	 Visitante visitante1 = new Visitante("Juan Perez", "123456789", 25, 3, "juan@gmail.com", "clave123");
	 visitantes.add(visitante1);
     Visitante visitante2 = new Visitante("Maria Gomez", "987654321", 30, 5, "maria@gmail.com", "pass456");
     visitantes.add(visitante2);
     Visitante visitante3 = new Visitante("Carlos Rodriguez", "555555555", 22, 1, "carlos@gmail.com", "qwerty");
     visitantes.add(visitante3);
     Visitante visitante4 = new Visitante("Ana Sanchez", "111122223", 28, 2, "ana@gmail.com", "abcd");
     visitantes.add(visitante4);
     Visitante visitante5 = new Visitante("Luis Torres", "999988887", 35, 4, "luis@gmail.com", "p@ssword");
     visitantes.add(visitante5);
     Visitante visitante6 = new Visitante("Laura Fernandez", "666677778", 31, 6, "laura@gmail.com", "securePass");
     visitantes.add(visitante6);
     Visitante visitante7 = new Visitante("Pedro Martinez", "444455556", 27, 7, "pedro@gmail.com", "peter123");
     visitantes.add(visitante7);
     Visitante visitante8 = new Visitante("Elena Castro", "888877776", 26, 8, "elena@gmail.com", "elenaPass");
     visitantes.add(visitante8);
     Visitante visitante9 = new Visitante("Diego Ramirez", "333322221", 29, 9, "diego@gmail.com", "diegoPass");
     visitantes.add(visitante9);
     Visitante visitante10 = new Visitante("Sofia Diaz", "777766665", 24, 10, "sofia@gmail.com", "sofiaPass");
     visitantes.add(visitante10);
	return visitantes;
}


public void setVisitantes(ArrayList<Visitante> visitantes) {

	this.visitantes = visitantes;

}

public ZOO(ArrayList<Animal> animales, ArrayList<Trabajador> trabajadores, ArrayList<Visitante> visitantes) {

	super();

	this.animales = animales;

	this.trabajadores = trabajadores;

	this.visitantes = visitantes;

}

public ZOO() {

	super();

	this.animales = new ArrayList<>();

	this.trabajadores = new ArrayList<>();

	this.visitantes = new ArrayList<>();

}



}
