package co.com.faturatech.mapper;

import co.com.faturatech.domain.Currencies;
import co.com.faturatech.dto.CurrenciesDTO;

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
public interface CurrenciesMapper {
    public CurrenciesDTO currenciesToCurrenciesDTO(Currencies currencies);

    public Currencies currenciesDTOToCurrencies(CurrenciesDTO currenciesDTO);

    public List<CurrenciesDTO> listCurrenciesToListCurrenciesDTO(
        List<Currencies> currenciess);

    public List<Currencies> listCurrenciesDTOToListCurrencies(
        List<CurrenciesDTO> currenciesDTOs);
}
