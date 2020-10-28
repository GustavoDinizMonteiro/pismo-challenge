package pismo.models;

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
	@Id
	@SequenceGenerator(allocationSize=1, name="se_transaction", sequenceName="se_transaction")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="se_transaction")
	private Long id;
	
	@Column(nullable = false)
	private Long amount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_id", nullable = false)
	private Account account;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="operation_type_id", nullable = false)
	private OperationType operationTypeId;
}
