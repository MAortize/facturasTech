package co.com.faturatech.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;



@Entity
@Table(name = "bill_details", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDetails implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "blld_id", unique = true, nullable = false)
    @NotNull
    private Integer blldId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bll_id")
    @NotNull
    private Bills bills;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cnc_id")
    @NotNull
    private Concepts concepts;
}
