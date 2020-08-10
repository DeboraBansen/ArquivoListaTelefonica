package persistencia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dados.Contato;

public class ContatoDAO {
	private ArquivoContatoDAO arquivoContatoDAO=new ArquivoContatoDAO();
	
	public void insert(Contato contato) {
		arquivoContatoDAO.salvaContatos(contato);
	}
	public void delete(Contato contato) {
		List<Contato> contatos=arquivoContatoDAO.leContatos();
		contatos.remove(contato);
		arquivoContatoDAO.salvaContatos(contatos);
	}
	public Map<Character, List<Contato>> getAll(){
		Map<Character, List<Contato>> contatos=new HashMap<Character, List<Contato>>();
		List<Contato> contato=arquivoContatoDAO.leContatos();
		
		for(char i=65;i<91;i++) {
			List<Contato> cont=new LinkedList<Contato>();
			for( int j=0;j<contato.size();j++) {
				if(contato.get(j).getNome().charAt(0)==i) {
					cont.add(contato.get(j));
				}
				
			}contatos.put(i, cont);
			
		}
		return contatos;
	}
}
