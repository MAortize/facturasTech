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
public class BillsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date bllDueDate;
    @NotNull
    private Integer bllId;
    private Date bllIssueDate;
    private Integer clnId_Clients;
    private Integer crrcId_Currencies;
    private Integer emtId_Emitters;
    private Integer lgsId_Logs;
    private Integer pymmId_PaymentMeans;
    private Integer pymmtId_PaymentMethods;
    private Integer pymtId_PaymentTerms;
    private Integer untmId_UnitsMeasurement;
}
