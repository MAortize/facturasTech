package co.com.faturatech.mapper;

import co.com.faturatech.domain.PaymentMeans;
import co.com.faturatech.dto.PaymentMeansDTO;

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
public interface PaymentMeansMapper {
    public PaymentMeansDTO paymentMeansToPaymentMeansDTO(
        PaymentMeans paymentMeans);

    public PaymentMeans paymentMeansDTOToPaymentMeans(
        PaymentMeansDTO paymentMeansDTO);

    public List<PaymentMeansDTO> listPaymentMeansToListPaymentMeansDTO(
        List<PaymentMeans> paymentMeanss);

    public List<PaymentMeans> listPaymentMeansDTOToListPaymentMeans(
        List<PaymentMeansDTO> paymentMeansDTOs);
}
