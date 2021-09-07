package za.ac.nwu.acsy.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.acsy.domain.persistence.MemberAccount;

public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long> {
}
