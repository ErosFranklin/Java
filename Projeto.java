package projeto;
import java.util.Scanner;
public class Projeto {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int quant_alunos;
		String prof, disciplina;
		System.out.printf("\n-=-=-=-=BEM-VINDO AO CADASTRO DE TURMA -=-=-=-=\n");
		System.out.printf("Informe o nome do docente: ");
		prof = sc.nextLine();
		System.out.print("Informe o nome da disciplina: ");
		disciplina = sc.nextLine();
		System.out.print("Informe a quantidade dos alunos na turma: ");
		quant_alunos = sc.nextInt();
		sc.nextLine();
		float notas[][] = new float[quant_alunos][3];
		Aluno alunos[] = new Aluno[quant_alunos];
		LerAlunos(alunos,notas);
		ImprimirAlunos(alunos,notas, prof, disciplina);
	}
	
	public static float CalcularMedia(float notas[][], int aluno){
		return (notas[aluno][0]+notas[aluno][1])/2;
	}
	
	public static void LerAlunos(Aluno alunos[],float notas[][]) {
		int i;
		System.out.printf("\n-=-=-=-= CADASTRO DE INFORMAÇÕES PESSOAIS-=-=-=-=\n");
		for(i=0;i<alunos.length;i++) {
			alunos[i]= new Aluno();
			System.out.printf("\nDigite o nome do %d° aluno: ",i+1);
			alunos[i].nome = sc.nextLine();
			System.out.printf("Digite a matrícula do %d° aluno: ",i+1);
			alunos[i].matricula = sc.nextLine();
			System.out.printf("Nota 1 do %dº aluno: ",i+1);
			notas[i][0] = sc.nextFloat();
			sc.nextLine();
			System.out.printf("Nota 2 do %dº aluno: ",i+1);
			notas[i][1] = sc.nextFloat();
			sc.nextLine();
			notas[i][2] = CalcularMedia(notas, i);
		}
	}
	
	public static void ImprimirAlunos(Aluno alunos[], float notas[][], String prof, String disc) {
		System.out.printf("Professor: %s Disciplina: %s \n", prof, disc);
		System.out.printf("\n-=-=-=-= ALUNOS -=-=-=-=\n");
		int i;
		for(i=0;i<alunos.length;i++) {
			System.out.printf("\n%d° aluno - %s\nMatricula: %s\nNota 1: %.2f\nNota 2: %.2f\nMédia: %.2f\n",(i+1),alunos[i].nome,alunos[i].matricula, notas[i][0], notas[i][1], notas[i][2]);
			if (notas[i][2] >= 7) {
				System.out.printf("\nSituação: APROVADO\n");
			} else if (notas[i][2] < 7 && notas[i][2] >= 4){
				System.out.printf("\nSituação: RECUPERAÇÃO\n");
			} else {
				System.out.printf("\nSituação: REPROVADO\n");
			}
		}
	}
}
