package za.ac.nwu.acsy.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.acsy.domain.persistence.MemberAccount;

@Repository
public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long> {
}
