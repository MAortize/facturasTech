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
public class EmittersDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String emtAddres;
    private String emtCompanyName;
    private String emtEmail;
    @NotNull
    private Integer emtId;
    private String emtName;
    private String emtNit;
    private String emtPhone;
    private Integer idtId_IdentificactionType;
    private Integer lbltId_LiabilityType;
    private Integer prstId_PersonType;
}
