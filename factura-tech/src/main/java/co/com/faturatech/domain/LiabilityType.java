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
@Table ( name="liability_type", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiabilityType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="lblt_id", unique=true, nullable=false)
		@NotNull
		private Integer lbltId;
		
	
	    
					@Column(name="lblt_code"   )
		private String lbltCode;	
    				@Column(name="lblt_name"   )
		private String lbltName;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="liabilityType")
		private List<Clients> clientses = new ArrayList<>();	
    	@OneToMany(fetch=FetchType.LAZY, mappedBy="liabilityType")
		private List<Emitters> emitterses = new ArrayList<>();	
        
}	