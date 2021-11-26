package co.com.faturatech.mapper;

import co.com.faturatech.domain.PersonType;
import co.com.faturatech.dto.PersonTypeDTO;

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
public interface PersonTypeMapper {
    public PersonTypeDTO personTypeToPersonTypeDTO(PersonType personType);

    public PersonType personTypeDTOToPersonType(PersonTypeDTO personTypeDTO);

    public List<PersonTypeDTO> listPersonTypeToListPersonTypeDTO(
        List<PersonType> personTypes);

    public List<PersonType> listPersonTypeDTOToListPersonType(
        List<PersonTypeDTO> personTypeDTOs);
}
