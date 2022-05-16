package it.polito.tdp.borders.model;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.event.GraphListener;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;


import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	

	Graph<Country, DefaultEdge> grafo;
	BordersDAO dao;
	Map <String, Country> stati; 
	Map <String, Country> mappaGrafo; 
	
	public Model() {
		dao = new BordersDAO();
		stati = new TreeMap <String, Country>();
		mappaGrafo = new HashMap <String, Country>();
		grafo = new SimpleGraph< Country, DefaultEdge>(DefaultEdge.class);
	}
	
	public Graph<Country, DefaultEdge> creaGrafo(int anno) {
		
		List<Border> coppie = dao.getCountryPairs(anno);
		
		for(Country c: dao.loadAllCountries()) {
			stati.put(c.getNomeBreve(), c);
		}
		
		for(Border b: coppie) {
			
			if(!mappaGrafo.containsKey(b.getState1ab()))
				this.mappaGrafo.put(b.getState1ab(), stati.get(b.getState1ab()));
			if(!mappaGrafo.containsKey(b.getState2ab()))
				this.mappaGrafo.put(b.getState2ab(), stati.get(b.getState2ab()));
				
		}
		
		//System.out.println(this.mappaGrafo.values());
		
		for(Country c : mappaGrafo.values()) {
			if(c != null)
			   this.grafo.addVertex(c);
		}
	
		
    	for (Border b : coppie) 
    		if(mappaGrafo.get(b.getState1ab())!= null && mappaGrafo.get(b.getState2ab()) != null)
    			this.grafo.addEdge(mappaGrafo.get(b.getState1ab()), mappaGrafo.get(b.getState2ab()));
	
    	  
    	
        	return grafo;

}
	
	public Set<DefaultEdge> trovaComponentiConnesse(Graph<Country, DefaultEdge> grafo , Country vertice ){
		//Set<DefaultEdge> connessioni = new HashSet<DefaultEdge>();
		
		return grafo.edgesOf(vertice);
	}
	
	
	
	
	public int contaCompConnesse(Country vertice) {
		
		Set<Country> confinanti = new HashSet<>();
		DepthFirstIterator <Country, DefaultEdge> iterator = new DepthFirstIterator <Country, DefaultEdge>(this.grafo, vertice);
		
		while(iterator.hasNext()) {
			confinanti.add(iterator.next());
		}
		
		return confinanti.size();
	}
	
	
	
//	
//	public Set<Country> getComponenteConnessa(Country vertice) {
//		Set<Country> visitati = new HashSet<>();
//		DepthFirstIterator <Country, DefaultEdge> it = new DepthFirstIterator <Country, DefaultEdge>(this.grafo, vertice);
//		
//		while(it.hasNext()) {
//			visitati.add(it.next());
//		}
//		return visitati;
//			
//	}


}
