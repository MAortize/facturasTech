package co.com.faturatech.mapper;

import co.com.faturatech.domain.IdentificactionType;
import co.com.faturatech.dto.IdentificactionTypeDTO;

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
public interface IdentificactionTypeMapper {
    public IdentificactionTypeDTO identificactionTypeToIdentificactionTypeDTO(
        IdentificactionType identificactionType);

    public IdentificactionType identificactionTypeDTOToIdentificactionType(
        IdentificactionTypeDTO identificactionTypeDTO);

    public List<IdentificactionTypeDTO> listIdentificactionTypeToListIdentificactionTypeDTO(
        List<IdentificactionType> identificactionTypes);

    public List<IdentificactionType> listIdentificactionTypeDTOToListIdentificactionType(
        List<IdentificactionTypeDTO> identificactionTypeDTOs);
}
