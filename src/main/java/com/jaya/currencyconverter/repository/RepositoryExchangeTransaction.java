/**
 * 
 */
package com.jaya.currencyconverter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaya.currencyconverter.entity.EntityExchangeTransaction;

/**
 * @author Priscila Gouveia
 *
 */
@Repository
public interface RepositoryExchangeTransaction extends CrudRepository<EntityExchangeTransaction, Long>{

	@Query(value = "SELECT * FROM Exchange_Transaction WHERE user_id = ?", nativeQuery = true )
	List<EntityExchangeTransaction> findAllTransactionsByUserId(Long userId);

}
