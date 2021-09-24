package za.ac.nwu.acsy.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsy.domain.dto.MemberInfoDto;
import za.ac.nwu.acsy.logic.flow.FetchMemberInfoFlow;
import za.ac.nwu.acsy.translator.MemberInfoTranslator;

import javax.transaction.Transactional;
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


}
