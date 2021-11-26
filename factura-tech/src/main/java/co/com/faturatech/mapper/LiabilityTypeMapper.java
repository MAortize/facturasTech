package co.com.faturatech.mapper;

import co.com.faturatech.domain.LiabilityType;
import co.com.faturatech.dto.LiabilityTypeDTO;

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
public interface LiabilityTypeMapper {
    public LiabilityTypeDTO liabilityTypeToLiabilityTypeDTO(
        LiabilityType liabilityType);

    public LiabilityType liabilityTypeDTOToLiabilityType(
        LiabilityTypeDTO liabilityTypeDTO);

    public List<LiabilityTypeDTO> listLiabilityTypeToListLiabilityTypeDTO(
        List<LiabilityType> liabilityTypes);

    public List<LiabilityType> listLiabilityTypeDTOToListLiabilityType(
        List<LiabilityTypeDTO> liabilityTypeDTOs);
}
