
package it.polito.tdp.borders;

import java.net.URL;
import java.util.ResourceBundle;

import org.jgrapht.graph.DefaultEdge;

import it.polito.tdp.borders.db.BordersDAO;
import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	private BordersDAO dao = new BordersDAO();
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtAnno"
    private TextField txtAnno; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private ComboBox<Country>cmbStati;


    @FXML
    void doCalcolaConfini(ActionEvent event) {
    	
    	this.txtResult.clear();
    	
    	int anno = Integer.parseInt(this.txtAnno.getText());
    	this.model.creaGrafo(anno);
    	int componentiConnesse = 0;
    	
    	for(Country c: this.model.creaGrafo(anno).vertexSet()) {
    		this.txtResult.appendText(c.getNomeBreve() +" "+ this.model.creaGrafo(anno).degreeOf(c) +"\n");
    		  componentiConnesse = this.model.contaCompConnesse(c);
    	}
    	
    	
    		this.txtResult.appendText("Componenti connesse grafo: " + String.valueOf(componentiConnesse));
    		
    		
    }
    
    @FXML
    void doClear(ActionEvent event) {

    	this.txtResult.clear();
    }

    @FXML
    void trovaStatiRaggiungibili(ActionEvent event) {
    	
    	int anno = Integer.parseInt(this.txtAnno.getText()); 
    	this.txtResult.appendText("Stati confinanti: "+ "\n");
    	for(DefaultEdge de: this.model.trovaComponentiConnesse(this.model.creaGrafo(anno), this.cmbStati.getValue())) {
    		this.txtResult.appendText(de + ", ") ;
    		
    	}
       
    }
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbStati != null : "fx:id=\"cmbStati\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	
    	for(Country c: this.dao.loadAllCountries()) 
    		this.cmbStati.getItems().add(c);
    	
    	
    }
    
    
    
    
    
}
