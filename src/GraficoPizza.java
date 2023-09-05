import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoPizza extends JFrame{
    public GraficoPizza(int ano) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Grafico Pizza");
        setSize(950, 700);
        setLocationRelativeTo(null);

        criarGrafico(ano);
        
        setVisible(true);
    }

    public void criarGrafico(int ano) {
        DefaultPieDataset pizza = new DefaultPieDataset();

        CalculaCrescimento calc = new CalculaCrescimento();

        double popArgentina = calc.calcular(Dados.POP_ARGENTINA, Dados.TAXA_ARGENTINA, ano);
        double popBolivia = calc.calcular(Dados.POP_BOLIVIA, Dados.TAXA_BOLIVIA, ano);
        double popBrasil = calc.calcular(Dados.POP_BRASIL, Dados.TAXA_BRASIL, ano);
        double popChile = calc.calcular(Dados.POP_CHILE, Dados.TAXA_CHILE, ano);
        double popColombia = calc.calcular(Dados.POP_COLOMBIA, Dados.TAXA_COLOMBIA, ano);
        double popEquador = calc.calcular(Dados.POP_EQUADOR, Dados.TAXA_EQUADOR, ano);
        double popGuiana = calc.calcular(Dados.POP_GUIANA, Dados.TAXA_GUIANA, ano);
        double popGuianaFrancesa = calc.calcular(Dados.POP_GUIANAFRANCESA, Dados.TAXA_GUIANAFRANCESA, ano);
        double popParaguai = calc.calcular(Dados.POP_PARAGUAI, Dados.TAXA_PARAGUAI, ano);
        double popPeru = calc.calcular(Dados.POP_PERU, Dados.TAXA_PERU, ano);
        double popSuriname = calc.calcular(Dados.POP_SURINAME, Dados.TAXA_SURINAME, ano);
        double popUruguai = calc.calcular(Dados.POP_URUGUAI, Dados.TAXA_URUGUAI, ano);
        double popVenezuela = calc.calcular(Dados.POP_VENEZUELA, Dados.TAXA_VENEZUELA, ano);

        pizza.setValue("Argentina", popArgentina);
        pizza.setValue("Bolivia", popBolivia);
        pizza.setValue("Brasil", popBrasil);
        pizza.setValue("Chile", popChile);
        pizza.setValue("Colombia", popColombia);
        pizza.setValue("Equador", popEquador);
        pizza.setValue("Guiana", popGuiana);
        pizza.setValue("Guiana Francesa", popGuianaFrancesa);
        pizza.setValue("Paraguai", popParaguai);
        pizza.setValue("Peru", popPeru);
        pizza.setValue("Suriname", popSuriname);
        pizza.setValue("Uruguai", popUruguai);
        pizza.setValue("Venezuela", popVenezuela);

        JFreeChart grafico = ChartFactory.createPieChart("Crescimento Populacional América Latina (Dados em milhões)", pizza, true, true, false);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
}
