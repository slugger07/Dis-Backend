package sgsits.cse.dis.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * <h1><b>InfrastructureLocation</b> class.</h1>
 * <p>This class is model for table <b>infrastructure_location</b> to act as DAO.
 * This table contains information of all the location for infrastructure.
 * @author Arjit Mishra,Devyani garg.
 * @version 1.0.
 * @since 25-JAN-2020.
 */
@Entity
@Table(name="infrastructure_location")
public class InfrastructureLocation {
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
	private String id;
	
	@Column(name = "name")
	private String name;

	
	public InfrastructureLocation() {
		super();
	}
	
	public InfrastructureLocation(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
