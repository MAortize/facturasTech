package co.com.faturatech.mapper;

import co.com.faturatech.domain.Countries;
import co.com.faturatech.dto.CountriesDTO;

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
public interface CountriesMapper {
    public CountriesDTO countriesToCountriesDTO(Countries countries);

    public Countries countriesDTOToCountries(CountriesDTO countriesDTO);

    public List<CountriesDTO> listCountriesToListCountriesDTO(
        List<Countries> countriess);

    public List<Countries> listCountriesDTOToListCountries(
        List<CountriesDTO> countriesDTOs);
}
