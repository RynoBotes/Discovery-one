package za.ac.nwu.acsy.logic.flow;

import za.ac.nwu.acsy.domain.dto.MemberInfoDto;

import java.util.List;

public interface FetchMemberInfoFlow {
    List<MemberInfoDto> getAllMembers();

   //MemberInfoDto createMember(MemberInfoDto memberInfoDto);
}
