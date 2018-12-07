package main;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import entity.Vendorinformation;
import entity.Vendormaster;
import service.VendorinformationService;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		VendorinformationService service = context.getBean(VendorinformationService.class);
		
		
	
		Date date = Calendar.getInstance().getTime();
		System.out.println(date);
		
		Vendormaster vendormaster = new Vendormaster();
		
		Vendorinformation newVendor = new Vendorinformation("LF1234", "VendorTest", "Modestraße", "1110", "Vienna", "Österreich", "06804005547", "nicolaus.rotter@adesso.at", "adesso.at", "IB4N", "VAT", date);
		
		Vendorinformation newVendor2 = new Vendorinformation("LF1234RAYA", "Raya Designs", "East Ball Road 711", "92805", "Anaheim Ca", "USA", "714/776-7252", "", "", "", "", date);
		
		Vendorinformation newVendor3 = new Vendorinformation("LF1234OFFICE", "Office Depot", "Washington", "2222", "Washington", "DC", "222-222-2222", "", "", "", "", date);
		
		Vendorinformation newVendor4 = new Vendorinformation("LF1234BING", "Bing Bang Jewelry", "153 Lafayette Street", "10013", "New York", "New York", "212-925-7010", "", "", "", "", date);
		
		service.updateVendor(newVendor2);
		service.updateVendor(newVendor3);
		service.updateVendor(newVendor4);
		
		//java.sql.Timestamp.valueOf(java.time.LocalDate.of(myYear, myMonth, myDay).atStartOfDay()))
		service.add(newVendor);
		//service.add(new Vendorinformation("LF12345", "Vendor2", "Modestraße", 1110, "Vienna", "Österreich", "06804005547", "nicolaus.rotter@adesso.at", "adesso.at", "IB4N", "VAT", new Timestamp(2018,12,23,11,01,30,300)));
		
		Integer id = newVendor.getId();
		
		System.out.println("ID: " + service.read(id).get().getId() + ", Vendorid: " + service.read(id).get().getVendorid());
		
		System.out.println("ammount of updated columns: " + service.updateVendorid("NEWID123", id));
		
		System.out.println("ID: " + service.read(id).get().getId() + ", Vendorid: " + service.read(id).get().getVendorid());
		
		newVendor.setVendorid("AMNEUESTEN123");
		
		service.updateVendor(newVendor);
		
		//service.remove(id);
		
		context.close();
	}
}
