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
@Table ( name="currencies", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currencies implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="crrc_id", unique=true, nullable=false)
		@NotNull
		private Integer crrcId;
		
	
	    
					@Column(name="crrc_adopter_country"   )
		private String crrcAdopterCountry;	
    				@Column(name="crrc_code"   )
		private String crrcCode;	
    				@Column(name="crrc_currency"   )
		private String crrcCurrency;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="currencies")
		private List<Bills> billses = new ArrayList<>();	
        
}	