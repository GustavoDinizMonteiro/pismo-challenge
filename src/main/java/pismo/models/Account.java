package pismo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_account")
@Getter @Setter
@EqualsAndHashCode(of = {"documentNumber"})
@ToString
@NoArgsConstructor
public class Account {
	@Id
	@SequenceGenerator(allocationSize=1, name="se_account", sequenceName="se_account")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="se_account")
	private Long id;
	
	@JsonProperty("document_number")
	@Column(name="document_number", nullable = false, unique = true)
	private String documentNumber;

	public Account(Long id) {
		this.id = id;
	}
}
