package za.ac.nwu.acsy.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.acsy.domain.dto.MemberInfoDto;
import za.ac.nwu.acsy.logic.flow.CreateMemberInfoFlow;
import za.ac.nwu.acsy.translator.MemberInfoTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class CreateMemberInfoFlowImpl implements CreateMemberInfoFlow
{
    private final MemberInfoTranslator memberInfoTranslator;

    public CreateMemberInfoFlowImpl(MemberInfoTranslator memberInfoTranslator)
    {
        this.memberInfoTranslator = memberInfoTranslator;
    }


    @Override
    public MemberInfoDto createMember(MemberInfoDto memberInfo)
    {
        if(null == memberInfo.getJoinDate())
        {
            memberInfo.setJoinDate(LocalDate.now());
        }
        return memberInfoTranslator.createMember(memberInfo);
    }
}
