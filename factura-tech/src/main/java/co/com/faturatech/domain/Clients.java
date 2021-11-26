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
@Table ( name="clients", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clients implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="cln_id", unique=true, nullable=false)
		@NotNull
		private Integer clnId;
		
	
			@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="cts_id"  	 )
		@NotNull
		private Cities cities;	
    		@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="idt_id"  	 )
		@NotNull
		private IdentificactionType identificactionType;	
    		@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="lblt_id"  	 )
		@NotNull
		private LiabilityType liabilityType;	
    		@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="prst_id"  	 )
		@NotNull
		private PersonType personType;	
        
					@Column(name="cln_address"   )
		private String clnAddress;	
    				@Column(name="cln_email"   )
		private String clnEmail;	
    				@Column(name="cln_fhone"   )
		private String clnFhone;	
    				@Column(name="cln_name"   )
		private String clnName;	
    				@Column(name="cln_nit"   )
		private String clnNit;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="clients")
		private List<Bills> billses = new ArrayList<>();	
        
}	