package za.ac.nwu.acsy.logic.flow;

import za.ac.nwu.acsy.domain.dto.MemberInfoDto;

public interface CreateMemberInfoFlow
{
    MemberInfoDto createMember(MemberInfoDto memberInfo);
}
