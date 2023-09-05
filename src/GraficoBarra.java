import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarra extends JFrame{
    
    String[] paises = {"Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Equador", "Guiana", "Guiana Francesa", "Paraguai", "Peru", "Suriname", "Uruguai", "Venezuela"};

    public GraficoBarra(String pais, int ano) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Grafico");
        setSize(950, 700);
        setLocationRelativeTo(null);

        criarGrafico(pais, ano);

        setVisible(true);
    }

    public void criarGrafico(String pais, int ano) {
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        double taxa = 0.0;
        double populacao = 0.0;

        int cont = 1;
        for(String estado : paises){
            if(estado.equals(pais)) 
                break;

            cont++;
        }
        
        switch(cont) {
            case 1:
                taxa = Dados.TAXA_ARGENTINA;
                populacao = Dados.POP_ARGENTINA;
                break;
            case 2:
                taxa = Dados.TAXA_BOLIVIA;
                populacao = Dados.POP_BOLIVIA;
                break;
            case 3:
                taxa = Dados.TAXA_BRASIL;
                populacao = Dados.POP_BRASIL;
                break;
            case 4:
                taxa = Dados.TAXA_CHILE;
                populacao = Dados.POP_CHILE;
                break;
            case 5:
                taxa = Dados.TAXA_COLOMBIA;
                populacao = Dados.POP_COLOMBIA;
                break;
            case 6:
                taxa = Dados.TAXA_EQUADOR;
                populacao = Dados.POP_EQUADOR;
                break;
            case 7:
                taxa = Dados.TAXA_GUIANA;
                populacao = Dados.POP_GUIANA;
                break;
            case 8:
                taxa = Dados.TAXA_GUIANAFRANCESA;
                populacao = Dados.POP_GUIANAFRANCESA;
                break;
            case 9:
                taxa = Dados.TAXA_PARAGUAI;
                populacao = Dados.POP_PARAGUAI;
                break;
            case 10:
                taxa = Dados.TAXA_PERU;
                populacao = Dados.POP_PERU;
                break;
            case 11:
                taxa = Dados.TAXA_SURINAME;
                populacao = Dados.POP_SURINAME;
                break;
            case 12:
                taxa = Dados.TAXA_URUGUAI;
                populacao = Dados.POP_URUGUAI;
                break;
            case 13:
                taxa = Dados.TAXA_VENEZUELA;
                populacao = Dados.POP_VENEZUELA;
                break;
            
        }

        System.out.println(taxa);
        System.out.println(populacao);

        barra.setValue(populacao, "2023", "");
        CalculaCrescimento calc = new CalculaCrescimento();
        for(int i = 2024; i <= ano; i++) 
            barra.setValue(calc.calcular(populacao, taxa, i), String.valueOf(i), "");
        

        //barra.setValue(45.5, "2023", "");
        //barra.setValue(20, "2024", "");
        //barra.setValue(10, "2025", "");
        //barra.setValue(5, "2026", "");
        //barra.setValue(2, "e", "");
        //barra.setValue(1, "f", "");

        JFreeChart grafico = ChartFactory.createBarChart("Crescimento Populacional", "Ano", "Milhões", barra, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
}
