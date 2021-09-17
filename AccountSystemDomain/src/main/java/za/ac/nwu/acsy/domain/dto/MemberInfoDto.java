package za.ac.nwu.acsy.domain.dto;

import za.ac.nwu.acsy.domain.persistence.MemberInfo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MemberInfoDto implements Serializable
{
    private String name;
    private String surname;
    private LocalDate joinDate;

    private static final long serialVersionUID = 6718470397603594190L;

    public MemberInfoDto() {
    }

    public MemberInfoDto(String name, String surname, LocalDate joinDate) {
        this.name = name;
        this.surname = surname;
        this.joinDate = joinDate;
    }

    public MemberInfoDto(MemberInfo memberInfo)
    {
        this.setName(memberInfo.getName());
        this.setSurname(memberInfo.getSurname());
        this.setJoinDate(memberInfo.getJoinedDate());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getJoinDate() {
        return joinDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberInfoDto that = (MemberInfoDto) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(joinDate, that.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, joinDate);
    }

    @Override
    public String toString() {
        return "MemberInfoDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }


}
