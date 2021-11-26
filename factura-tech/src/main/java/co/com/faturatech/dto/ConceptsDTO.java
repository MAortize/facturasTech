package co.com.faturatech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConceptsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cncAmount;
    private String cncCode;
    private String cncDescripcion;
    @NotNull
    private Integer cncId;
    private Integer cncIva;
    private Long cncSubtotal;
    private Long cncTotalPayment;
    private Long cncUnitValue;
    private Integer untmId_UnitsMeasurement;
}
