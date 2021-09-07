package za.ac.nwu.acsy.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.acsy.domain.persistence.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
