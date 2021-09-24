package za.ac.nwu.acsy.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.acsy.domain.persistence.MemberInfo;

@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {
}
