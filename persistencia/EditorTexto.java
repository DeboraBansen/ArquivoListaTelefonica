package persistencia;
import java.util.LinkedList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;

public class EditorTexto {
	
	public List<String> leTexto(String caminho){
		List<String> dados=new LinkedList<String>();
		
		FileReader arq;
		BufferedReader lerArq;
		
		try {
			arq=new FileReader(caminho);
			lerArq=new BufferedReader(arq);
			String s=lerArq.readLine();
			
			while(s!=null) {
				dados.add(s);
				s=lerArq.readLine();
			}
			arq.close();
		}catch(Exception e) {
			System.out.println("Erro ao manipular arquivo");
			System.exit(0);
		}
		return dados;
	}
	
	public void gravaTexto(String caminho,List<String> dados) {
		FileWriter arq;
		try {
			arq=new FileWriter(caminho);
			for(String i:dados) {
				arq.write(i+"\n");
			}
			arq.close();
		}catch(Exception e) {
			System.out.println("Erro ao manipular arquivo");
			System.exit(0);
		}
	}
	
	public void gravaTexto(String caminho,String linha) {
		FileWriter arq;
		
		try {
			arq=new FileWriter(caminho,true);
			arq.write(linha+"\n");
			arq.close();
			
		}catch(Exception e) {
			System.out.println("Erro ao manipular arquivo");
			System.exit(0);
		}
	}
}
