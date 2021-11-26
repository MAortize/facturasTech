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
@Table ( name="emitters", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emitters implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="emt_id", unique=true, nullable=false)
		@NotNull
		private Integer emtId;
		
	
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
        
					@Column(name="emt_addres"   )
		private String emtAddres;	
    				@Column(name="emt_company_name"   )
		private String emtCompanyName;	
    				@Column(name="emt_email"   )
		private String emtEmail;	
    				@Column(name="emt_name"   )
		private String emtName;	
    				@Column(name="emt_nit"   )
		private String emtNit;	
    				@Column(name="emt_phone"   )
		private String emtPhone;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="emitters")
		private List<Bills> billses = new ArrayList<>();	
        
}	