package za.ac.nwu.acsy.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.acsy.domain.persistence.MemberInfo;

@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long>
{
    @Query(value = "SELECT "+
            "       at "+
            "       FROM "+
            "       MemberInfo at "+
            "   WHERE at.memberID = :memberID " )
    MemberInfo getMemberByIdentify(Long memberID);


//    @Query(value = "UPDATE"+
//            "   member_info "+
//            "   SET"+
//            "   curr_amount = curr_amount +:currency "  +
//            "   WHERE MEMBER_ID = :memberID ", nativeQuery = true)
//    MemberInfo addCurrencyToMember(Long memberID, Long currency);
}
