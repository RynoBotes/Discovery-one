package za.ac.nwu.acsy.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.acsy.domain.persistence.MemberInfo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "MemberInfo",
        description = "A dto that represents the Member Information")
public class MemberInfoDto implements Serializable
{
    private Long memberID;
    private String name;
    private String surname;
    private LocalDate joinDate;
    private Long currAmount;


    private static final long serialVersionUID = 6718470397603594190L;

    public MemberInfoDto() {
    }

    public MemberInfoDto(Long memberId, String name, String surname, LocalDate joinDate, Long currAmount) {
        this.memberID = memberId;
        this.name = name;
        this.surname = surname;
        this.joinDate = joinDate;
        this.currAmount = currAmount;
    }

    public MemberInfoDto(MemberInfo memberInfo)
    {
        this.setMemberID(memberInfo.getMemberID());;
        this.setName(memberInfo.getName());
        this.setSurname(memberInfo.getSurname());
        this.setJoinDate(memberInfo.getJoinedDate());
        this.setCurrAmount(memberInfo.getCurrAmount());
    }



    @ApiModelProperty(position = 1,
            value = "MemberInfo ID",
            name = "Member ID",
            notes = "The ID of the Member",
            dataType = "java.lang.Long",
            example = "125684",
            required = true)
    public Long getMemberID() {
        return memberID;
    }

    @ApiModelProperty(position = 2,
            value = "MemberInfo Name",
            name = "Name",
            notes = "The name of the Member",
            dataType = "java.lang.String",
            example = "Chavonne",
            required = true)
    public String getName() {
        return name;
    }

    @ApiModelProperty(position = 3,
            value = "MemberInfo surname",
            name = "surname",
            notes = "The surname of the member",
            dataType = "java.lang.String",
            example = "Jackson",
            required = true)
    public String getSurname() {
        return surname;
    }

    @ApiModelProperty(position = 4,
            value = "MemberInfo JoinDate",
            name = "Joined Date",
            notes = "The Joining date of the member",
            dataType = "java.lang.String",
            example = "1999-05-10")
    public LocalDate getJoinDate() {
        return joinDate;
    }



    @ApiModelProperty(position = 5,
            value = "MemberInfo currAmount",
            name = "Currency Amount",
            notes = "The Amount of the members ",
            dataType = "java.lang.String",
            example = "500")
    public Long getCurrAmount() {
        return currAmount;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public void setCurrAmount(Long currAmount) {
        this.currAmount = currAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }



    @JsonIgnore
    public MemberInfo getMemberInfo()
    {
        return new MemberInfo(getMemberID(), getName(), getSurname(), getJoinDate(), getCurrAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberInfoDto that = (MemberInfoDto) o;
        return Objects.equals(memberID, that.memberID) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(joinDate, that.joinDate) && Objects.equals(currAmount, that.currAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, name, surname, joinDate, currAmount);
    }

    @Override
    public String toString() {
        return "MemberInfoDto{" +
                "memberID=" + memberID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", joinDate=" + joinDate +
                ", currAmount=" + currAmount +
                '}';
    }
}
