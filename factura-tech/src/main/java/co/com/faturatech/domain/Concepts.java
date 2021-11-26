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
@Table ( name="concepts", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Concepts implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="cnc_id", unique=true, nullable=false)
		@NotNull
		private Integer cncId;
		
	
			@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="untm_id"  	 )
		@NotNull
		private UnitsMeasurement unitsMeasurement;	
        
					@Column(name="cnc_amount"   )
		private Long cncAmount;	
    				@Column(name="cnc_code"   )
		private String cncCode;	
    				@Column(name="cnc_descripcion"   )
		private String cncDescripcion;	
    				@Column(name="cnc_iva"   )
		private Integer cncIva;	
    				@Column(name="cnc_subtotal"   )
		private Long cncSubtotal;	
    				@Column(name="cnc_total_payment"   )
		private Long cncTotalPayment;	
    				@Column(name="cnc_unit_value"   )
		private Long cncUnitValue;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="concepts")
		private List<BillDetails> billDetailses = new ArrayList<>();	
        
}	