package apresentacao;
import java.util.Scanner;


import dados.Contato;
import negocio.ListaTelefonica;

public class Main {
	private static ListaTelefonica listaTelefonica=new ListaTelefonica();
	private static Scanner s=new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
		

	}
	public static void imprimeMenu() {
		System.out.println("Escolha uma opcao: ");
		System.out.println("0- Sair");
		System.out.println("1- Cadastrar Contato");
		System.out.println("2- Remover Contato");
		System.out.println("3- Exibir Contatos");
	}
	
	public static void menu() {
		int opcao =-1;
		while(opcao!=0) {
			
			imprimeMenu();
			opcao=s.nextInt();
			
			switch(opcao) {
			case 0:
				break;
			case 1:
				listaTelefonica.adicionarContato(novoContato());;
				break;
			case 2:
				listaTelefonica.removerContato(escolherContato());
				break;
			case 3:
				exibirContatos();
				break;
			default:
				System.out.println("Numero invalido!");
				break;
				
			}
		}
	}
	
	public static Contato novoContato() {
		Contato c=new Contato();
		
		System.out.println("Digite o nome do contato:");
		c.setNome(s.next());
		
		System.out.println("Digite o numero de telefone:");
		c.setTelefone(s.nextInt());
		
		return c;
	}
	
	public static Contato escolherContato() {
		System.out.println("Digite a primeira letra do contato que deseja remover:");
		char letra=s.next().charAt(0);
		letra=Character.toUpperCase(letra);
	
		mostrarContatos(letra);
		System.out.println("Digite o numero do contato que deseja remover:");
		int escolha=s.nextInt();
		
		if(escolha<listaTelefonica.buscarContato(letra).size()) {
			return listaTelefonica.buscarContato(letra).get(escolha);
		}else {
			return null;
		}
		
	}
	
	public static void mostrarContatos(Character letra) {
		for(int i=0;i<listaTelefonica.buscarContato(letra).size();i++) {
			System.out.println("Contato "+i);
			System.out.println(listaTelefonica.buscarContato(letra).get(i).toString());
			System.out.println();
		}
	}
	
	public static void exibirContatos() {
		
		for(char i=65;i<91;i++) {
			String s=String.valueOf(i);
			System.out.println(s+" :");
			System.out.println();
			for(int j=0;j<1;j++) {
				mostrarContatos(i);
				System.out.println();
			}
		}
		
		
	}

}
