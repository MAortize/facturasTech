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
@Table ( name="payment_means", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMeans implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="pymm_id", unique=true, nullable=false)
		@NotNull
		private Integer pymmId;
		
	
	    
					@Column(name="pymm_name"   )
		private String pymmName;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="paymentMeans")
		private List<Bills> billses = new ArrayList<>();	
        
}	