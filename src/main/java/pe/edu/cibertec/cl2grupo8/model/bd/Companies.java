package pe.edu.cibertec.cl2grupo8.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_companies")
public class Companies {
	@Id
	private Integer id_company;
	
	@Column(name = "name_company")
	private String name_company;
}
