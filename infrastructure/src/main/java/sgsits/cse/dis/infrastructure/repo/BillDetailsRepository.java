package sgsits.cse.dis.infrastructure.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.infrastructure.model.BillDetails;

/**
 * <h1>BillDetailsRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 04-OCT-2020
 */

@Repository
public interface BillDetailsRepository extends JpaRepository<BillDetails, String> {

	long deleteStockBillById(String id);
	List<BillDetails> findByNameOfSupplierContaining(String name);
	List<BillDetails> findByDateOfPurchase(Date date);
	List<BillDetails> findByDateOfPurchaseBetween(Date date1,Date date2);

}
