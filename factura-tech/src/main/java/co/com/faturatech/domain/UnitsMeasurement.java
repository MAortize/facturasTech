package co.com.faturatech.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/
@Entity
@Table ( name="units_measurement", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitsMeasurement implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="untm_id", unique=true, nullable=false)
		@NotNull
		private Integer untmId;
		
	
	    
					@Column(name="untm_code"   )
		private String untmCode;	
    				@Column(name="untm_name"   )
		private String untmName;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="unitsMeasurement")
		private List<Bills> billses = new ArrayList<>();	
    	@OneToMany(fetch=FetchType.LAZY, mappedBy="unitsMeasurement")
		private List<Concepts> conceptses = new ArrayList<>();	
        
}	