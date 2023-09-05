public class CalculaCrescimento {
    

    public double calcular(double populacao, double taxa, int ano) {
        for(int i = 2024; i <= ano; i++) 
            populacao += populacao*(taxa*0.01);
        
        return populacao;
    }

}
