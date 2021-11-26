package co.com.faturatech.service.facade;

import java.util.Base64;

import https.SERVICESFACTURATECHStub;
import https.SERVICESFACTURATECHStub.FtechActionDownloadPDFFile;
import https.SERVICESFACTURATECHStub.FtechActionDownloadPDFFileResponse;

public class FacturaTechServiceFacadeImpl implements FacturaTechServiceFacade {

	@Override
	public String getFactura(String username, String password, String folio, String prefijo) throws Exception {
		String decodificado = "";
		try {
			//lo que llama el servicio
			SERVICESFACTURATECHStub stub = new SERVICESFACTURATECHStub();
			//input
			FtechActionDownloadPDFFile ftechActionDownloadXMLFile24 = new FtechActionDownloadPDFFile();

			ftechActionDownloadXMLFile24.setUsername("cgdata04102021");
			ftechActionDownloadXMLFile24
					.setPassword("41c6ef0247d178bf1d9f33309eab84ab6f71d03d10bbe431c8777e90428bb50b");
			ftechActionDownloadXMLFile24.setPrefijo("TCFA");
			ftechActionDownloadXMLFile24.setFolio("16901");
			//Response y el stub que hace la invocacion
			FtechActionDownloadPDFFileResponse response=stub.ftechActionDownloadPDFFile(ftechActionDownloadXMLFile24);
			System.out.println(response.get_return().getResourceData());
			
			//Se decodifica el response para pasarlo a formato string normal y obtener la respuesta xml
		    byte[] responseXML = Base64.getDecoder().decode(response.get_return().getResourceData().getBytes());
		    
		    //Se crea el string del response decodificado 
		    decodificado = new String(responseXML);
		    
			//DTOResponse.setBase64Decodificada(response.get_return().getResourceData()));
		} catch (Exception e) {
			throw e;
		}
		return decodificado;
	}

}
