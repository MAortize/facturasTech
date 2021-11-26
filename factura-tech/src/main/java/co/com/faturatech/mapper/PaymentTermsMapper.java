package co.com.faturatech.mapper;

import co.com.faturatech.domain.PaymentTerms;
import co.com.faturatech.dto.PaymentTermsDTO;

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
public interface PaymentTermsMapper {
    public PaymentTermsDTO paymentTermsToPaymentTermsDTO(
        PaymentTerms paymentTerms);

    public PaymentTerms paymentTermsDTOToPaymentTerms(
        PaymentTermsDTO paymentTermsDTO);

    public List<PaymentTermsDTO> listPaymentTermsToListPaymentTermsDTO(
        List<PaymentTerms> paymentTermss);

    public List<PaymentTerms> listPaymentTermsDTOToListPaymentTerms(
        List<PaymentTermsDTO> paymentTermsDTOs);
}
