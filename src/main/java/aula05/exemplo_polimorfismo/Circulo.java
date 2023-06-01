package aula05.exemplo_polimorfismo;

public class Circulo extends Forma{
	
	public Circulo() {
		super("Circulo");
	}
	
	public String desenhar() {
		return "Sou um circulo e tenho meu próprio desenho";		
	}
	
	public String calculaArea() {
		return "Minha área pode ser calculada";
	}

}
