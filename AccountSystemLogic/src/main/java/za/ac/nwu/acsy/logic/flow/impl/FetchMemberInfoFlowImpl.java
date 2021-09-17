package za.ac.nwu.acsy.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.acsy.domain.dto.MemberInfoDto;
import za.ac.nwu.acsy.logic.flow.FetchMemberInfoFlow;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchMemberInfoFlowImpl implements FetchMemberInfoFlow
{

    @Override
    public List<MemberInfoDto> getAllMembers() {
        List<MemberInfoDto> memberInfoDtos = new ArrayList<>();
        memberInfoDtos.add(new MemberInfoDto("Jan","Braai", LocalDate.now()));

        return memberInfoDtos;
    }
}
