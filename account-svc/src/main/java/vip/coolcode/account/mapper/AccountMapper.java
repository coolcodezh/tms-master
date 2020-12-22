package vip.coolcode.account.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import vip.coolcode.account.model.Account;

import java.util.List;

@Mapper
@Component
public interface AccountMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    @Select("select * from account ")
    List<Account> selectAll( @Param("pageNum") int pageNum,
                             @Param("pageSize") int pageSize);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}