package quarta_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;

public class PrincipalLivro {
	
	public static void main(String[] args) {
		
		List<Livro> listaLivro = new ArrayList<Livro>();
		List<Autor> listaAutor = new ArrayList<Autor>();
		
		int op = 0;
		do {
			op = Util.menuPrincipal();
			switch (op) {
			case 1:
				Util.cadastrarAutor(listaAutor);
				break;
			case 2:
				Util.cadastrarLivro(listaLivro, listaAutor);
				break;
				
				
			}
		} while (op != 8);
			
		
		
		
		
		
	}

}
