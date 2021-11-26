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
public class LiabilityTypeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String lbltCode;
    @NotNull
    private Integer lbltId;
    private String lbltName;
}
