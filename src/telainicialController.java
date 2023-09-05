import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class telainicialController implements Initializable{

    @FXML
    private ComboBox<String> combo_paises;

    @FXML
    private Button botao_calculo;
    
    @FXML
    private TextField campo_ano;
    
    ObservableList<String> listaPaises = FXCollections.observableArrayList("Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Equador", "Guiana", "Guiana Francesa", "Paraguai", "Peru", "Suriname", "Uruguai", "Venezuela", "Todos");
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        combo_paises.setValue("Países");
        combo_paises.setItems(listaPaises);

    }

    @FXML
    void calcular(ActionEvent event) {
        if(Integer.valueOf(campo_ano.getText()) < 2023) {
            System.out.println("Insira um valor maior que 2023");
        } else if(combo_paises.getValue().equals("Todos")){
            new GraficoPizza(Integer.valueOf(campo_ano.getText()));
        }else {
            new GraficoBarra(combo_paises.getValue(), Integer.valueOf(campo_ano.getText()));
        }
    }
}
