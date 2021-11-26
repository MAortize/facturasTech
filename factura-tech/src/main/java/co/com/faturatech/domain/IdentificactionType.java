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
@Table ( name="identificaction_type", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificactionType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="idt_id", unique=true, nullable=false)
		@NotNull
		private Integer idtId;
		
	
	    
					@Column(name="idt_code"   )
		private String idtCode;	
    				@Column(name="idt_name"   )
		private String idtName;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="identificactionType")
		private List<Clients> clientses = new ArrayList<>();	
    	@OneToMany(fetch=FetchType.LAZY, mappedBy="identificactionType")
		private List<Emitters> emitterses = new ArrayList<>();	
        
}	