package za.ac.nwu.acsy.translator;

import za.ac.nwu.acsy.domain.dto.MemberInfoDto;

import java.util.List;

public interface MemberInfoTranslator {
    List<MemberInfoDto> getAllMembers();

    MemberInfoDto createMember(MemberInfoDto memberInfoDto);
}
