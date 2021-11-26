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
@Table ( name="logs", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logs implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="lgs_id", unique=true, nullable=false)
		@NotNull
		private Integer lgsId;
		
	
			@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="usr_id"  	 )
		@NotNull
		private Users users;	
        
					@Column(name="lgs_downlodad_date"   )
		private Date lgsDownlodadDate;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="logs")
		private List<Bills> billses = new ArrayList<>();	
        
}	