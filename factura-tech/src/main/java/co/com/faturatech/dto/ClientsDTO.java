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
public class ClientsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String clnAddress;
    private String clnEmail;
    private String clnFhone;
    @NotNull
    private Integer clnId;
    private String clnName;
    private String clnNit;
    private Integer ctsId_Cities;
    private Integer idtId_IdentificactionType;
    private Integer lbltId_LiabilityType;
    private Integer prstId_PersonType;
}
