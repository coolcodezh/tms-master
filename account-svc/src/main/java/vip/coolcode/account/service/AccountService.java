package vip.coolcode.account.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vip.coolcode.account.dto.AccountDto;
import vip.coolcode.account.mapper.AccountMapper;
import vip.coolcode.account.model.Account;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public PageInfo<Account> selectAllAccount(int pageNum,int pageSize) {
        //设置查询分页参数
        PageHelper.startPage(pageNum, pageSize);
        //查询
        List<Account> list = accountMapper.selectAll(pageNum, pageSize);
        //分页信息
        PageInfo<Account> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Transactional(isolation=Isolation.READ_UNCOMMITTED,
            propagation = Propagation.REQUIRED)
    public AccountDto create(String name,String email,String phoneNumber) {
        System.out.println("服务 - 注册服务");
        Account account = new Account();
        account.setName(name);
        account.setEmail(email);
        account.setPhoneNumber(phoneNumber);

        int n = accountMapper.insert(account);

        /*if(n>0) {
            AccountDto dto = new AccountDto();
            dto.setId(account.getId().toString());
            dto.setName(account.getName());
            dto.setEmail(account.getEmail());
            return dto;
        }*/

        return null;
    }
}
