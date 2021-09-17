package za.ac.nwu.acsy.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.acsy.domain.dto.MemberInfoDto;
import za.ac.nwu.acsy.domain.persistence.MemberInfo;
import za.ac.nwu.acsy.repo.persistence.MemberInfoRepository;
import za.ac.nwu.acsy.translator.MemberInfoTranslator;

import java.util.ArrayList;
import java.util.List;

public class MemberInfoTranslatorImpl implements MemberInfoTranslator {

    MemberInfoRepository memberInfoRepository;

    @Autowired
    public MemberInfoTranslatorImpl(MemberInfoRepository memberInfoRepository) {
        this.memberInfoRepository = memberInfoRepository;
    }

    @Override
    public List<MemberInfoDto> getAllMembers() {
        List<MemberInfoDto> memberInfoDtos = new ArrayList<>();
        try{
            for(MemberInfo memberInfo : memberInfoRepository.findAll())
            {
                memberInfoDtos.add(new MemberInfoDto(memberInfo));
            }
        }catch(Exception e)
        {
            throw new RuntimeException("Error in DataBase",e);
        }
        return null;
    }
}
