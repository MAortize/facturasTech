package co.com.faturatech.mapper;

import co.com.faturatech.domain.Clients;
import co.com.faturatech.dto.ClientsDTO;

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
public interface ClientsMapper {
    @Mapping(source = "cities.ctsId", target = "ctsId_Cities")
    @Mapping(source = "identificactionType.idtId", target = "idtId_IdentificactionType")
    @Mapping(source = "liabilityType.lbltId", target = "lbltId_LiabilityType")
    @Mapping(source = "personType.prstId", target = "prstId_PersonType")
    public ClientsDTO clientsToClientsDTO(Clients clients);

    @Mapping(source = "ctsId_Cities", target = "cities.ctsId")
    @Mapping(source = "idtId_IdentificactionType", target = "identificactionType.idtId")
    @Mapping(source = "lbltId_LiabilityType", target = "liabilityType.lbltId")
    @Mapping(source = "prstId_PersonType", target = "personType.prstId")
    public Clients clientsDTOToClients(ClientsDTO clientsDTO);

    public List<ClientsDTO> listClientsToListClientsDTO(List<Clients> clientss);

    public List<Clients> listClientsDTOToListClients(
        List<ClientsDTO> clientsDTOs);
}
