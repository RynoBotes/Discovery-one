package za.ac.nwu.acsy.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.acsy.logic.flow.CreateMemberInfoFlow;
import za.ac.nwu.acsy.translator.MemberInfoTranslator;

@Transactional
@Component
public class CreateMemberInfoFlowImpl implements CreateMemberInfoFlow
{
    private final MemberInfoTranslator memberInfoTranslator;

    public CreateMemberInfoFlowImpl(MemberInfoTranslator memberInfoTranslator)
    {
        this.memberInfoTranslator = memberInfoTranslator;
    }


//    @Override
//    public MemberInfoDto createMember(MemberInfoDto memberInfo, AccountTypeDto accountTypeDto)
//    {
//        if(null == memberInfo.getJoinDate())
//        {
//            memberInfo.setJoinDate(LocalDate.now());
//        }
//        if(null == memberInfo.getCurrAmount())
//        {
//            memberInfo.setCurrAmount(0L);
//        }
//        return memberInfoTranslator.createMember(memberInfo, accountTypeDto);
//    }
}
