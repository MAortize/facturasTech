package co.com.faturatech.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table ( name="payment_terms", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTerms implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="pymt_id", unique=true, nullable=false)
		@NotNull
		private Integer pymtId;
		
	
	    
					@Column(name="pymt_descripcion"   )
		private String pymtDescripcion;	
    				@Column(name="pymy_name"   )
		private String pymyName;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="paymentTerms")
		private List<Bills> billses = new ArrayList<>();	
        
}	