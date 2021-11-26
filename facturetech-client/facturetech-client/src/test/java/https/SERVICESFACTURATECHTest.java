/**
 * SERVICESFACTURATECHTest.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.0 Built on : Aug 01,
 * 2021 (07:27:19 HST)
 */
package https;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Base64;


/*
 *  SERVICESFACTURATECHTest Junit test case
 */

public class SERVICESFACTURATECHTest extends junit.framework.TestCase {

//  /** Auto generated test method */
//  public void testftechActionGetCUFEFile() throws java.lang.Exception {
//
//    https.SERVICESFACTURATECHStub stub =
//        new https
//            .SERVICESFACTURATECHStub(); // the default implementation should point to the right
//                                        // endpoint
//
//    https.SERVICESFACTURATECHStub.FtechActionGetCUFEFile ftechActionGetCUFEFile16 =
//        (https.SERVICESFACTURATECHStub.FtechActionGetCUFEFile)
//            getTestObject(https.SERVICESFACTURATECHStub.FtechActionGetCUFEFile.class);
//    // TODO : Fill in the ftechActionGetCUFEFile16 here
//
//    assertNotNull(stub.ftechActionGetCUFEFile(ftechActionGetCUFEFile16));
//  }
//
//  /** Auto generated test method */
//  public void testftechActionUploadInvoiceFileLayout() throws java.lang.Exception {
//
//    https.SERVICESFACTURATECHStub stub =
//        new https
//            .SERVICESFACTURATECHStub(); // the default implementation should point to the right
//                                        // endpoint
//
//    https.SERVICESFACTURATECHStub.FtechActionUploadInvoiceFileLayout
//        ftechActionUploadInvoiceFileLayout18 =
//            (https.SERVICESFACTURATECHStub.FtechActionUploadInvoiceFileLayout)
//                getTestObject(
//                    https.SERVICESFACTURATECHStub.FtechActionUploadInvoiceFileLayout.class);
//    // TODO : Fill in the ftechActionUploadInvoiceFileLayout18 here
//
//    assertNotNull(stub.ftechActionUploadInvoiceFileLayout(ftechActionUploadInvoiceFileLayout18));
//  }
//
//  /** Auto generated test method */
//  public void testftechActionGetQRImageFile() throws java.lang.Exception {
//
//    https.SERVICESFACTURATECHStub stub =
//        new https
//            .SERVICESFACTURATECHStub(); // the default implementation should point to the right
//                                        // endpoint
//
//    https.SERVICESFACTURATECHStub.FtechActionGetQRImageFile ftechActionGetQRImageFile20 =
//        (https.SERVICESFACTURATECHStub.FtechActionGetQRImageFile)
//            getTestObject(https.SERVICESFACTURATECHStub.FtechActionGetQRImageFile.class);
//    // TODO : Fill in the ftechActionGetQRImageFile20 here
//
//    assertNotNull(stub.ftechActionGetQRImageFile(ftechActionGetQRImageFile20));
//  }
//
//  /** Auto generated test method */
//  public void testftechActionDocumentStatusFile() throws java.lang.Exception {
//
//    https.SERVICESFACTURATECHStub stub =
//        new https
//            .SERVICESFACTURATECHStub(); // the default implementation should point to the right
//                                        // endpoint
//
//    https.SERVICESFACTURATECHStub.FtechActionDocumentStatusFile ftechActionDocumentStatusFile22 =
//        (https.SERVICESFACTURATECHStub.FtechActionDocumentStatusFile)
//            getTestObject(https.SERVICESFACTURATECHStub.FtechActionDocumentStatusFile.class);
//    // TODO : Fill in the ftechActionDocumentStatusFile22 here
//
//    assertNotNull(stub.ftechActionDocumentStatusFile(ftechActionDocumentStatusFile22));
//  }
//  


  /** Auto generated test method */
  public void testftechActionDownloadXMLFile() throws java.lang.Exception {

    https.SERVICESFACTURATECHStub stub =
        new https
            .SERVICESFACTURATECHStub(); 
                                        

    https.SERVICESFACTURATECHStub.FtechActionDownloadXMLFile ftechActionDownloadXMLFile24 =
        (https.SERVICESFACTURATECHStub.FtechActionDownloadXMLFile)
            getTestObject(https.SERVICESFACTURATECHStub.FtechActionDownloadXMLFile.class);
    
    //Enviamos los datos para solicitar el response
    ftechActionDownloadXMLFile24.setUsername("cgdata04102021");
    ftechActionDownloadXMLFile24.setPassword("41c6ef0247d178bf1d9f33309eab84ab6f71d03d10bbe431c8777e90428bb50b");
    ftechActionDownloadXMLFile24.setPrefijo("TCFA");
    ftechActionDownloadXMLFile24.setFolio("16901");
    
    https.SERVICESFACTURATECHStub.FtechActionDownloadXMLFileResponse response=stub.ftechActionDownloadXMLFile(ftechActionDownloadXMLFile24);
    
    //Se decodifica el response para pasarlo a formato string normal y obtener la respuesta xml
    byte[] responseXML = Base64.getDecoder().decode(response.get_return().getResourceData().getBytes());
    
    //Se crea el string del response decodificado 
    String decodificado = new String(responseXML);
    //Creamos un archivo para obtener la respuesta en un estado fisico y poder manipularlo con facilidad
    File ruta = new File("C:\\Users\\Usuario\\git\\FacturaTech\\facturetech-client\\facturetech-client\\src\\test\\java\\https\\carpetaPrueba\\archivoPrueba.xml");
    
    //Escribimos dentro del archivo la respuesta decodificada que obtuvimos y finalmente lo guardamos
    BufferedWriter out = new BufferedWriter(new FileWriter(ruta));
    out.write(decodificado);
    out.close();
    
    
    

    assertNotNull(stub.ftechActionDownloadXMLFile(ftechActionDownloadXMLFile24));
  }

//  /** Auto generated test method */
//  public void testftechActionUploadInvoiceFile() throws java.lang.Exception {
//
//    https.SERVICESFACTURATECHStub stub =
//        new https
//            .SERVICESFACTURATECHStub(); // the default implementation should point to the right
//                                        // endpoint
//
//    https.SERVICESFACTURATECHStub.FtechActionUploadInvoiceFile ftechActionUploadInvoiceFile26 =
//        (https.SERVICESFACTURATECHStub.FtechActionUploadInvoiceFile)
//            getTestObject(https.SERVICESFACTURATECHStub.FtechActionUploadInvoiceFile.class);
//    // TODO : Fill in the ftechActionUploadInvoiceFile26 here
//    
//    assertNotNull(stub.ftechActionUploadInvoiceFile(ftechActionUploadInvoiceFile26));
//  }
//
//  /** Auto generated test method */
//  public void testftechActionDownloadPDFFile() throws java.lang.Exception {
//
//    https.SERVICESFACTURATECHStub stub =
//        new https
//            .SERVICESFACTURATECHStub(); // the default implementation should point to the right
//                                        // endpoint
//
//    https.SERVICESFACTURATECHStub.FtechActionDownloadPDFFile ftechActionDownloadPDFFile28 =
//        (https.SERVICESFACTURATECHStub.FtechActionDownloadPDFFile)
//            getTestObject(https.SERVICESFACTURATECHStub.FtechActionDownloadPDFFile.class);
//    // TODO : Fill in the ftechActionDownloadPDFFile28 here
//    
//    
//    
//    ftechActionDownloadPDFFile28.setUsername("cgdata04102021");
//    ftechActionDownloadPDFFile28.setPassword("41c6ef0247d178bf1d9f33309eab84ab6f71d03d10bbe431c8777e90428bb50b");
//    ftechActionDownloadPDFFile28.setPrefijo("TCFA");
//    ftechActionDownloadPDFFile28.setFolio("16901");
//
//    https.SERVICESFACTURATECHStub.FtechActionDownloadPDFFileResponse response=stub.ftechActionDownloadPDFFile(ftechActionDownloadPDFFile28);
//    
//    System.out.println(response.get_return().getResourceData());
//
//    assertNotNull(response);
//  }
//
//  /** Auto generated test method */
//  public void testftechActionGetQRFile() throws java.lang.Exception {
//
//    https.SERVICESFACTURATECHStub stub =
//        new https
//            .SERVICESFACTURATECHStub(); // the default implementation should point to the right
//                                        // endpoint
//
//    https.SERVICESFACTURATECHStub.FtechActionGetQRFile ftechActionGetQRFile30 =
//        (https.SERVICESFACTURATECHStub.FtechActionGetQRFile)
//            getTestObject(https.SERVICESFACTURATECHStub.FtechActionGetQRFile.class);
//    // TODO : Fill in the ftechActionGetQRFile30 here
//
//    assertNotNull(stub.ftechActionGetQRFile(ftechActionGetQRFile30));
//  }
//
  // Create an ADBBean and provide it as the test object
  public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type)
      throws java.lang.Exception {
    return (org.apache.axis2.databinding.ADBBean) type.newInstance();
  }
}
