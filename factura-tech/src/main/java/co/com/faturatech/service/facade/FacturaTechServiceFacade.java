package co.com.faturatech.service.facade;

public interface FacturaTechServiceFacade {

	public String getFactura(String username,String password, String folio, String prefijo) throws Exception;
	
	//el strin se cambia por el mapeo response
}
