package co.com.faturatech.mapper;

import co.com.faturatech.domain.UnitsMeasurement;
import co.com.faturatech.dto.UnitsMeasurementDTO;

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
public interface UnitsMeasurementMapper {
    public UnitsMeasurementDTO unitsMeasurementToUnitsMeasurementDTO(
        UnitsMeasurement unitsMeasurement);

    public UnitsMeasurement unitsMeasurementDTOToUnitsMeasurement(
        UnitsMeasurementDTO unitsMeasurementDTO);

    public List<UnitsMeasurementDTO> listUnitsMeasurementToListUnitsMeasurementDTO(
        List<UnitsMeasurement> unitsMeasurements);

    public List<UnitsMeasurement> listUnitsMeasurementDTOToListUnitsMeasurement(
        List<UnitsMeasurementDTO> unitsMeasurementDTOs);
}
