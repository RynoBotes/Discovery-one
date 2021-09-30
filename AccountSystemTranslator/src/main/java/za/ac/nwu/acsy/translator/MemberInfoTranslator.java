package za.ac.nwu.acsy.translator;

import za.ac.nwu.acsy.domain.dto.MemberInfoDto;

import java.util.List;

public interface MemberInfoTranslator
{
    List<MemberInfoDto> getAllMembers();

    MemberInfoDto getMemberByIdentify(Long memberID);


    MemberInfoDto addCurrencyToMember(Long memberID, Long currency);
}
