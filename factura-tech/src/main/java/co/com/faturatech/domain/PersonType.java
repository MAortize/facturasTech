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
@Table ( name="person_type", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="prst_id", unique=true, nullable=false)
		@NotNull
		private Integer prstId;
		
	
	    
					@Column(name="prst_code"   )
		private String prstCode;	
    				@Column(name="prst_id1"   )
		private String prstId1;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="personType")
		private List<Clients> clientses = new ArrayList<>();	
    	@OneToMany(fetch=FetchType.LAZY, mappedBy="personType")
		private List<Emitters> emitterses = new ArrayList<>();	
        
}	