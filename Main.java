import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double rendaS,rendaP,rendaC,gmedico,geduc,impostoS,impostoP,impostoC,deducao,gdeducao;	
		Locale.setDefault(Locale.US);
		DecimalFormat dc = new DecimalFormat("0.00"); 
		
		System.out.println("Renda anual com salário: ");
		rendaS = sc.nextDouble();
		System.out.println("Renda anual com prestação de serviço: ");
		rendaP = sc.nextDouble();
		System.out.println("Renda anual com ganho de capital: ");
		rendaC = sc.nextDouble();
		System.out.println("Gastos médicos: ");
		gmedico = sc.nextDouble();
		System.out.println("Gastos educacionais: ");
		geduc = sc.nextDouble();
		
		if(rendaS/12 < 3000) {
			impostoS = 0;
		}else if(rendaS/12 <=5000) {
			impostoS = rendaS * 0.1;
		}else {
			impostoS = rendaS * 0.2;
		}
		impostoP = rendaP * 0.15;
		impostoC = rendaC * 0.2;
		
		if((gmedico+geduc) >= (impostoS+impostoP+impostoC) * 0.3) {
			deducao = (impostoS+impostoP+impostoC) * 0.3;
		}else {
			deducao = gmedico+geduc;
		}
			
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA" + "\n");
		System.out.println("Consolidado de renda: ");
		System.out.println("Imposto sobre salário: " + dc.format(impostoS));
		System.out.println("Imposto sobre serviços: " + dc.format(impostoP));
		System.out.println("Imposto sobre ganho de capital: " + impostoC + "\n");
		System.out.println("DEDUÇÕES: ");
		System.out.println("Máximo dedutível: " + dc.format((impostoS+impostoP+impostoC) * 0.3));
		System.out.println("Gastos dedutíveis: " + dc.format(gmedico + geduc) + "\n");
		System.out.println("RESUMO: ");
		System.out.println("Imposto bruto total: " + dc.format(impostoS+impostoP+impostoC));
		System.out.println("Abatimento: " + deducao);
		System.out.println("Imposto devido: " + dc.format(((impostoS+impostoP+impostoC) - deducao)));

		sc.close();
	}

}
