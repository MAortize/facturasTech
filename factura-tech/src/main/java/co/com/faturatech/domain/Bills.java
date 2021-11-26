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
@Table ( name="bills", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bills implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="bll_id", unique=true, nullable=false)
		@NotNull
		private Integer bllId;
		
	
			@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="cln_id"  	 )
		@NotNull
		private Clients clients;	
    		@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="crrc_id"  	 )
		@NotNull
		private Currencies currencies;	
    		@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="emt_id"  	 )
		@NotNull
		private Emitters emitters;	
    		@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="lgs_id"  	 )
		@NotNull
		private Logs logs;	
    		@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="pymm_id"  	 )
		@NotNull
		private PaymentMeans paymentMeans;	
    		@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="pymmt_id"  	 )
		@NotNull
		private PaymentMethods paymentMethods;	
    		@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="pymt_id"  	 )
		@NotNull
		private PaymentTerms paymentTerms;	
    		@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="untm_id"  	 )
		@NotNull
		private UnitsMeasurement unitsMeasurement;	
        
					@Column(name="bll_due_date"   )
		private Date bllDueDate;	
    				@Column(name="bll_issue_date"   )
		private Date bllIssueDate;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="bills")
		private List<BillDetails> billDetailses = new ArrayList<>();	
        
}	