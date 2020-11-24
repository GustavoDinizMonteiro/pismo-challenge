package pismo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_transaction")
@Getter @Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@NoArgsConstructor
public class Transaction {
	private static final int DEBIT_OPERATION_MODIFIER = -1;
	private static final Long PAYMENT_OPERATION_ID = (long) 4;

	@Id
	@SequenceGenerator(allocationSize=1, name="se_transaction", sequenceName="se_transaction")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="se_transaction")
	private Long id;
	
	@Column(nullable = false)
	private Double amount;
	
	@JsonAlias({ "account_id" })
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_id", nullable = false)
	private Account account;
	
	@JsonAlias({ "operation_type_id" })
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="operation_type_id", nullable = false)
	private OperationType operationType;

	@Column(name = "event_date", nullable = false)
	private Date eventDate = new Date();

	public void setAmount(Double amount) {
		if (!operationType.getId().equals(PAYMENT_OPERATION_ID)) 
			amount *= DEBIT_OPERATION_MODIFIER;

		this.amount = amount;
	}
}
