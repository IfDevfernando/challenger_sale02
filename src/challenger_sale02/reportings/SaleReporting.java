package challenger_sale02.reportings;

import java.util.Set;

import challenger_sale02.entities.Sale;

public class SaleReporting {

	
	
	public double totalSale(Set<Sale> sales,String seller) {
		return sales.stream()
		.filter(sale -> sale.getSeller().equals(seller))
		.mapToDouble(Sale :: getTotal)
		.sum();
	}
	

	
}
