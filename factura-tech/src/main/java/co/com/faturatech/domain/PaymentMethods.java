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
@Table ( name="payment_methods", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethods implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="pymmt_id", unique=true, nullable=false)
		@NotNull
		private Integer pymmtId;
		
	
	    
					@Column(name="pymmt_id1"   )
		private String pymmtId1;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="paymentMethods")
		private List<Bills> billses = new ArrayList<>();	
        
}	