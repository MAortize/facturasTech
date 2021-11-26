package co.com.faturatech.mapper;

import co.com.faturatech.domain.Logs;
import co.com.faturatech.dto.LogsDTO;

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
public interface LogsMapper {
    @Mapping(source = "users.usrId", target = "usrId_Users")
    public LogsDTO logsToLogsDTO(Logs logs);

    @Mapping(source = "usrId_Users", target = "users.usrId")
    public Logs logsDTOToLogs(LogsDTO logsDTO);

    public List<LogsDTO> listLogsToListLogsDTO(List<Logs> logss);

    public List<Logs> listLogsDTOToListLogs(List<LogsDTO> logsDTOs);
}
