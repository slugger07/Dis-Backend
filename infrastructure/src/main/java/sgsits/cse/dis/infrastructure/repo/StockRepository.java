package sgsits.cse.dis.infrastructure.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.infrastructure.model.StockDetails;
/**
 * <h1>StockRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 25-JAN-2020
 */
@Repository("stockRepository")
public interface StockRepository extends JpaRepository<StockDetails, Long> {
	List<StockDetails> findByItemName(String itemName);
}
