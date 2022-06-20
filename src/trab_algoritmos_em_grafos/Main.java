package trab_algoritmos_em_grafos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Header
		String cabecalho = "   _____              ____        \r\n" + "  / ___/__________ __/ __/_  _____\r\n"
				+ " / / _ / ___/ __  /\\  / _  \\/ ___/\r\n" + "/ /_/ / /  / /_/ / / / /_/ /__  ) \r\n"
				+ "\\____/_/   \\_____\\/_/\\____/____/  \r\n" + "\r\n";

		// Versão do produto
		cabecalho += "Trabalho Algoritmos em Grafos versão 2.2 19/06/2022" + "\r\n";

		// Membros do grupo
		cabecalho += "Grupo: Gustavo Soares, Matheus Ryuji, Maxwuell Junio, Rafael Penido" + "\r\n\r\n";

		System.out.print(cabecalho);

		// Lendo arquivo TXT e povoando arraylists de professores e disciplinas para a criação dos conjuntos de vértices
		Reader reader = new Reader();
		ArrayList<String> arquivo = new ArrayList<String>();
		ArrayList<String> professores = new ArrayList<String>(); //Para criar os vértices do primeiro conjunto
		ArrayList<String> disciplinas = new ArrayList<String>(); //Para criar os vértices do segundo conjunto
		arquivo = reader.readFile();
		int quantidadeDeLinhas = arquivo.size();
		String splitLinha[] = new String[3];
		for(String linha : arquivo){
			splitLinha = linha.split(" ");
			disciplinas.add(splitLinha[0] + " " + splitLinha[2]);
			professores.add(splitLinha[1] );
		}
		
		// Instanciando e povoando grafo com os vértices
		Grafo<String> grafo = new Grafo<String>("NAO DIRECIONADO");
		for(String professor : professores){
			grafo.adicionarVerticeProfessores(professor);
		}
		for(String disciplina : disciplinas){
			grafo.adicionarVerticeDisciplinas(disciplina);
		}

		// Validação #1 - Não podem ter mais de um professor dando a mesma matéria
		boolean validacao1 = false;
		int countValidacao;
		for (int i = 0; i < quantidadeDeLinhas; i++) {
			countValidacao = 0;
			for (int j = 0; j < quantidadeDeLinhas; j++) {
				if(disciplinas.get(i).equals(disciplinas.get(j))){
					countValidacao++;
				}
				if(countValidacao > 1){
					validacao1 = true;
				}
			}
		}

		// Se não houver disciplinas repetidas, segue o código
		if(validacao1 == true){
			System.out.println("Disciplinas repetidas, verifique o arquivo de entrada!");
		}else{
			// Para cada linha do arquivo TXT o código irá tentar organizar os horários na semana
			for (int i = 0; i < quantidadeDeLinhas; i++) {
				grafo.alocaHorario(professores.get(i), disciplinas.get(i));
			}
		}

		//Menu para verificação dos resultados
		int menuOption = 0;
		String tempOption = "";
		Scanner input = new Scanner(System.in);
		String pause = new String();

		System.out.print("\nAperte enter para continuar... ");
		pause = input.nextLine();

		while(menuOption != 9){
			System.out.println("\n* Menu para análise dos horários *");
			System.out.println("1 - Conferir horários por período");
			System.out.println("2 - Conferir horários por professor");
			System.out.println("9 - Sair");
			System.out.print("\nDigite uma opção: ");

			try{
				menuOption = input.nextInt();
			}catch(InputMismatchException e){
				input.next();
			}

			if(menuOption == 1){
				System.out.print("Informe o período: ");
				tempOption = input.next();
				grafo.tabelaDeHorariosPeriodo(tempOption);
			}else if(menuOption == 2){
				System.out.print("Digite o nome do professor: ");
				tempOption = input.next();
				grafo.tabelaDeHorariosProfessor(tempOption);
			}else if(menuOption == 9){
				System.out.println("\nProf! Dá total pra gente, por favor :)");
				System.out.println("\nObrigado ^^");
			}else{
				System.out.println("\nOpção não existente! ");
			}
		}
		
	}

}
