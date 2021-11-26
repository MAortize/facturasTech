package co.com.faturatech.mapper;

import co.com.faturatech.domain.PaymentMethods;
import co.com.faturatech.dto.PaymentMethodsDTO;

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
public interface PaymentMethodsMapper {
    public PaymentMethodsDTO paymentMethodsToPaymentMethodsDTO(
        PaymentMethods paymentMethods);

    public PaymentMethods paymentMethodsDTOToPaymentMethods(
        PaymentMethodsDTO paymentMethodsDTO);

    public List<PaymentMethodsDTO> listPaymentMethodsToListPaymentMethodsDTO(
        List<PaymentMethods> paymentMethodss);

    public List<PaymentMethods> listPaymentMethodsDTOToListPaymentMethods(
        List<PaymentMethodsDTO> paymentMethodsDTOs);
}
