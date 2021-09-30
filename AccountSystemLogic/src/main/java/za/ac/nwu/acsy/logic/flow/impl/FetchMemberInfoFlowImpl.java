package za.ac.nwu.acsy.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.acsy.domain.dto.MemberInfoDto;
import za.ac.nwu.acsy.logic.flow.FetchMemberInfoFlow;
import za.ac.nwu.acsy.translator.MemberInfoTranslator;

import java.util.List;

@Transactional
@Component
public class FetchMemberInfoFlowImpl implements FetchMemberInfoFlow
{
    private final MemberInfoTranslator memberInfoTranslator;

    @Autowired
    public FetchMemberInfoFlowImpl(MemberInfoTranslator memberInfoTranslator)
    {
        this.memberInfoTranslator = memberInfoTranslator;
    }


    @Override
    public List<MemberInfoDto> getAllMembers()
    {
        return memberInfoTranslator.getAllMembers();
    }

    @Override
    public MemberInfoDto getMemberByNumber(Long memberID) {
        return memberInfoTranslator.getMemberByIdentify(memberID);
    }

    @Override
    public MemberInfoDto addCurrency(Long memberID, Long currency) {
        return memberInfoTranslator.addCurrencyToMember(memberID, currency);
    }


}
