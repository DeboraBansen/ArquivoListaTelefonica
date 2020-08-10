package negocio;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dados.Contato;
import persistencia.ContatoDAO;

public class ListaTelefonica {
	private ContatoDAO contatoDAO=new ContatoDAO();
	
	public ListaTelefonica() {
		//contatoDAO.getAll();
	}
	
	public void adicionarContato(Contato contato) {
		contatoDAO.insert(contato);
	}
	
	public void removerContato(Contato contato) {
		contatoDAO.delete(contato);
	}
	
	public List<Contato> buscarContato(Character letra){
		List<Contato> contato=new LinkedList<Contato>();
		
		contato=contatoDAO.getAll().get(letra);
		
		return contato;
	}
	
	public Map<Character, List<Contato>> listarContatos(){
		return contatoDAO.getAll();
	}
}
