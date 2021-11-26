package co.com.faturatech.mapper;

import co.com.faturatech.domain.Concepts;
import co.com.faturatech.dto.ConceptsDTO;

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
public interface ConceptsMapper {
    @Mapping(source = "unitsMeasurement.untmId", target = "untmId_UnitsMeasurement")
    public ConceptsDTO conceptsToConceptsDTO(Concepts concepts);

    @Mapping(source = "untmId_UnitsMeasurement", target = "unitsMeasurement.untmId")
    public Concepts conceptsDTOToConcepts(ConceptsDTO conceptsDTO);

    public List<ConceptsDTO> listConceptsToListConceptsDTO(
        List<Concepts> conceptss);

    public List<Concepts> listConceptsDTOToListConcepts(
        List<ConceptsDTO> conceptsDTOs);
}
