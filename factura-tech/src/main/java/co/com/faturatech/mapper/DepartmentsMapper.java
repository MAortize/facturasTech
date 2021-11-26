package co.com.faturatech.mapper;

import co.com.faturatech.domain.Departments;
import co.com.faturatech.dto.DepartmentsDTO;

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
public interface DepartmentsMapper {
    @Mapping(source = "countries.cntId", target = "cntId_Countries")
    public DepartmentsDTO departmentsToDepartmentsDTO(Departments departments);

    @Mapping(source = "cntId_Countries", target = "countries.cntId")
    public Departments departmentsDTOToDepartments(
        DepartmentsDTO departmentsDTO);

    public List<DepartmentsDTO> listDepartmentsToListDepartmentsDTO(
        List<Departments> departmentss);

    public List<Departments> listDepartmentsDTOToListDepartments(
        List<DepartmentsDTO> departmentsDTOs);
}
