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
@Table ( name="countries", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Countries implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="cnt_id", unique=true, nullable=false)
		@NotNull
		private Integer cntId;
		
	
	    
					@Column(name="cnt_name"   )
		private String cntName;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="countries")
		private List<Departments> departmentses = new ArrayList<>();	
        
}	