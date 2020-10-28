package pismo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_operation_type")
@Getter @Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@NoArgsConstructor
public class OperationType {
	@Id
	@SequenceGenerator(allocationSize=1, name="se_operation_type", sequenceName="se_operation_type")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="se_operation_type")
	private Long id;
	
	@Column(nullable = false)
	private String description;

	public OperationType(String description) {
		this.description = description;
	}
}
