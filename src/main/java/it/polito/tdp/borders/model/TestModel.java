package it.polito.tdp.borders.model;

import java.util.Set;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		//System.out.println(model.creaGrafo(1817));
		for(Country c: model.creaGrafo(1817).vertexSet()) {
			if(c.getNomeBreve().compareTo("ITA")==0) {
				System.out.println(model.trovaComponentiConnesse(model.creaGrafo(1817), c));
			}
			
		}
//        Set<Country> stampa = null;
//		for(Country c : model.creaGrafo(1817).vertexSet()) {
//			if(c.getNomeBreve().compareTo("ITA")==0)
//				stampa = model.getComponenteConnessa(c);
//		}
//		System.out.println(stampa);
		
		
//		System.out.println("Creo il grafo relativo al 2000");
//		model.createGraph(2000);
		
//		List<Country> countries = model.getCountries();
//		System.out.format("Trovate %d nazioni\n", countries.size());

//		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		
		
	}

}
