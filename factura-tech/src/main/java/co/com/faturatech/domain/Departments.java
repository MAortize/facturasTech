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
@Table ( name="departments", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departments implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="dpt_id", unique=true, nullable=false)
		@NotNull
		private Integer dptId;
		
	
			@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="cnt_id"  	 )
		@NotNull
		private Countries countries;	
        
					@Column(name="dpt_name"   )
		private String dptName;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="departments")
		private List<Cities> citieses = new ArrayList<>();	
        
}	