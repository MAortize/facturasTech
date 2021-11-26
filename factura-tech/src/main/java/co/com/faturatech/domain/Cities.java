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
@Table ( name="cities", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cities implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="cts_id", unique=true, nullable=false)
		@NotNull
		private Integer ctsId;
		
	
			@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="dpt_id"  	 )
		@NotNull
		private Departments departments;	
        
					@Column(name="cts_name"   )
		private String ctsName;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="cities")
		private List<Clients> clientses = new ArrayList<>();	
        
}	