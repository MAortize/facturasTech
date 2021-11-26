package co.com.faturatech.mapper;

import co.com.faturatech.domain.Cities;
import co.com.faturatech.dto.CitiesDTO;

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
public interface CitiesMapper {
    @Mapping(source = "departments.dptId", target = "dptId_Departments")
    public CitiesDTO citiesToCitiesDTO(Cities cities);

    @Mapping(source = "dptId_Departments", target = "departments.dptId")
    public Cities citiesDTOToCities(CitiesDTO citiesDTO);

    public List<CitiesDTO> listCitiesToListCitiesDTO(List<Cities> citiess);

    public List<Cities> listCitiesDTOToListCities(List<CitiesDTO> citiesDTOs);
}
