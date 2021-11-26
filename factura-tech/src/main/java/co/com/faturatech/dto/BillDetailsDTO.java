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
public class BillDetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Integer blldId;
    private Integer bllId_Bills;
    private Integer cncId_Concepts;
}
