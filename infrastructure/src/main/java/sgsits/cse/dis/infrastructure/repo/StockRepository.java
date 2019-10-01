package sgsits.cse.dis.infrastructure.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.infrastructure.model.StockDetails;

@Repository("stockRepository")
public interface StockRepository extends JpaRepository<StockDetails, Long> {
	List<StockDetails> findByItemName(String itemName);
}
