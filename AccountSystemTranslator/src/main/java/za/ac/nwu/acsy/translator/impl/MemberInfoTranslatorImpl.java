package za.ac.nwu.acsy.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsy.domain.dto.MemberInfoDto;
import za.ac.nwu.acsy.domain.persistence.MemberInfo;
import za.ac.nwu.acsy.repo.persistence.MemberInfoRepository;
import za.ac.nwu.acsy.translator.MemberInfoTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberInfoTranslatorImpl implements MemberInfoTranslator {

    private final MemberInfoRepository memberInfoRepository;


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
        return memberInfoDtos;
    }

    @Override
    public MemberInfoDto getMemberByIdentify(Long memberID)
    {
        try
        {
            MemberInfo memberInfo = memberInfoRepository.getMemberByIdentify(memberID);
            return new MemberInfoDto(memberInfo);

        }catch (Exception e)
        {
            throw new RuntimeException("Could not retrieve member from DataBase. ",e);
        }

    }

    @Override
    public MemberInfoDto addCurrencyToMember(Long memberID, Long currency)
    {
        MemberInfo memberInfo;
        try
        {
            memberInfo = memberInfoRepository.getMemberByIdentify(memberID);
            if(memberInfo.getCurrAmount()+currency > 0 )
            {
                memberInfo.setCurrAmount(memberInfo.getCurrAmount() + currency);
            }else
            {
                throw new RuntimeException();
            }
            return new MemberInfoDto(memberInfo);
        }catch (Exception e)
        {
            throw new RuntimeException("Can't update database", e);
        }

    }


}
