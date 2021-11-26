package co.com.faturatech.mapper;

import co.com.faturatech.domain.Emitters;
import co.com.faturatech.dto.EmittersDTO;

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
public interface EmittersMapper {
    @Mapping(source = "identificactionType.idtId", target = "idtId_IdentificactionType")
    @Mapping(source = "liabilityType.lbltId", target = "lbltId_LiabilityType")
    @Mapping(source = "personType.prstId", target = "prstId_PersonType")
    public EmittersDTO emittersToEmittersDTO(Emitters emitters);

    @Mapping(source = "idtId_IdentificactionType", target = "identificactionType.idtId")
    @Mapping(source = "lbltId_LiabilityType", target = "liabilityType.lbltId")
    @Mapping(source = "prstId_PersonType", target = "personType.prstId")
    public Emitters emittersDTOToEmitters(EmittersDTO emittersDTO);

    public List<EmittersDTO> listEmittersToListEmittersDTO(
        List<Emitters> emitterss);

    public List<Emitters> listEmittersDTOToListEmitters(
        List<EmittersDTO> emittersDTOs);
}
