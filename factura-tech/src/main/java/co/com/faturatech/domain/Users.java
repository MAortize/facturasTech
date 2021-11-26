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
@Table ( name="users", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="usr_id", unique=true, nullable=false)
		@NotNull
		private Integer usrId;
		
	
	    
					@Column(name="usr_name"   )
		private String usrName;	
    				@Column(name="usr_password"   )
		private String usrPassword;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
		private List<Logs> logses = new ArrayList<>();	
        
}	