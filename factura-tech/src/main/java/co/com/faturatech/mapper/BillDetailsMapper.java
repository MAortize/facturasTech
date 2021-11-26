package co.com.faturatech.mapper;

import co.com.faturatech.domain.BillDetails;
import co.com.faturatech.dto.BillDetailsDTO;

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
public interface BillDetailsMapper {
    @Mapping(source = "bills.bllId", target = "bllId_Bills")
    @Mapping(source = "concepts.cncId", target = "cncId_Concepts")
    public BillDetailsDTO billDetailsToBillDetailsDTO(BillDetails billDetails);

    @Mapping(source = "bllId_Bills", target = "bills.bllId")
    @Mapping(source = "cncId_Concepts", target = "concepts.cncId")
    public BillDetails billDetailsDTOToBillDetails(
        BillDetailsDTO billDetailsDTO);

    public List<BillDetailsDTO> listBillDetailsToListBillDetailsDTO(
        List<BillDetails> billDetailss);

    public List<BillDetails> listBillDetailsDTOToListBillDetails(
        List<BillDetailsDTO> billDetailsDTOs);
}
