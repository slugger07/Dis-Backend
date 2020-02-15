package sgsits.cse.dis.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * <h1><b></b> class.</h1>
 * <p>This class is model for table <b></b> to act as DAO.
 * This table contains
 * @author Arjit Mishra,Devyani garg.
 * @version 1.0.
 * @since 25-JAN-2020.
 */
@Entity
@Table(name = "infrastructure_type")
public class InfrastructureType {
   
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
	private String id;
	
	@Column(name = "type")
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}