package co.com.faturatech.mapper;

import co.com.faturatech.domain.Bills;
import co.com.faturatech.dto.BillsDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface BillsMapper {
    @Mapping(source = "clients.clnId", target = "clnId_Clients")
    @Mapping(source = "currencies.crrcId", target = "crrcId_Currencies")
    @Mapping(source = "emitters.emtId", target = "emtId_Emitters")
    @Mapping(source = "logs.lgsId", target = "lgsId_Logs")
    @Mapping(source = "paymentMeans.pymmId", target = "pymmId_PaymentMeans")
    @Mapping(source = "paymentMethods.pymmtId", target = "pymmtId_PaymentMethods")
    @Mapping(source = "paymentTerms.pymtId", target = "pymtId_PaymentTerms")
    @Mapping(source = "unitsMeasurement.untmId", target = "untmId_UnitsMeasurement")
    public BillsDTO billsToBillsDTO(Bills bills);

    @Mapping(source = "clnId_Clients", target = "clients.clnId")
    @Mapping(source = "crrcId_Currencies", target = "currencies.crrcId")
    @Mapping(source = "emtId_Emitters", target = "emitters.emtId")
    @Mapping(source = "lgsId_Logs", target = "logs.lgsId")
    @Mapping(source = "pymmId_PaymentMeans", target = "paymentMeans.pymmId")
    @Mapping(source = "pymmtId_PaymentMethods", target = "paymentMethods.pymmtId")
    @Mapping(source = "pymtId_PaymentTerms", target = "paymentTerms.pymtId")
    @Mapping(source = "untmId_UnitsMeasurement", target = "unitsMeasurement.untmId")
    public Bills billsDTOToBills(BillsDTO billsDTO);

    public List<BillsDTO> listBillsToListBillsDTO(List<Bills> billss);

    public List<Bills> listBillsDTOToListBills(List<BillsDTO> billsDTOs);
}
