package challenger_sale02.program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import challenger_sale02.entities.Sale;
import challenger_sale02.reportings.SaleReporting;

public class Main {

	public static void main(String[] args) {
		
System.out.println("============= CHALLENGER SALE 02 ==============");
		
		String path ="C:\\Users\\usedo\\OneDrive\\Documentos\\curso_devSuperiro_spring\\Java_Devsuperiror_expert\\in.csv";
		
		
		try (BufferedReader br= new BufferedReader(new FileReader (path))){
			
			SaleReporting report = new SaleReporting();
			
			Set<Sale> sales = new HashSet<>();
			
			Set<String> uniqueSeller = new HashSet<>();
			
			
			
			String line;
				while((line = br.readLine()) != null) {
					
					
					String[] parts = line.split(",");
					
					if(parts.length == 5) {
					String seller = parts[2];
					int month = Integer.parseInt(parts[0]);
		            int year = Integer.parseInt(parts[1]);
		            int items = Integer.parseInt(parts[3]);
		            double total = Double.parseDouble(parts[4]);
		            
		            Sale sale = new Sale(month, year, seller, items, total);
		            
		            sales.add(sale);
					uniqueSeller.add(seller);
					
				}
			}
				

				for(String seller: uniqueSeller) {
					
					double totalSales = report.totalSale(sales, seller);
					
					System.out.printf(seller+" - R$ %.2f \n",totalSales);
				}
				
					
		}
		catch(IOException e) {
			System.out.println("ERROR "+e.getMessage());
			
		}

	}

}
