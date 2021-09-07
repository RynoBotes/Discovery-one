package za.ac.nwu.acsy.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.acsy.domain.persistence.MemberInfo;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {
}
