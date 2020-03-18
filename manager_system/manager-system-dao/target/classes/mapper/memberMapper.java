package mapper;

import dao.member;

public interface memberMapper {
    int deleteByPrimaryKey(String id);

    int insert(member record);

    int insertSelective(member record);

    member selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(member record);

    int updateByPrimaryKey(member record);
}