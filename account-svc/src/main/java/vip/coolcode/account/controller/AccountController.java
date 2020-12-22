package vip.coolcode.account.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vip.coolcode.account.dto.AccountDto;
import vip.coolcode.account.dto.CreateAccountRequest;
import vip.coolcode.account.dto.GenericAccountResponse;
import vip.coolcode.account.model.Account;
import vip.coolcode.account.service.AccountService;
import vip.coolcode.common.error.ServiceException;

import javax.validation.Valid;
import java.util.List;

/* @RestController是 @Controller和 @ResponseBody组合而成*/

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/getall")
    public PageInfo<Account> getAllAccount(@RequestParam("pageNum")
                                                       int pageNum,
                                           @RequestParam("pageSize")
                                                   int pageSize) {
        System.out.println("查询所有账户 控制器方法");
        return accountService.selectAllAccount(pageNum,pageSize);

    }

    @PostMapping("/create")
    public GenericAccountResponse createAccount(
            @RequestBody
            @Valid
            CreateAccountRequest accountRequest) {

        System.out.println("控制器 - 注册服务");
        AccountDto accountDto = null;/*accountService.create(accountRequest.getName(),
                                                      accountRequest.getEmail(),
                                                    accountRequest.getPhoneNumber());
*/
        if(accountDto == null) {
            throw new ServiceException("注册失败,请检查邮箱或电话号码,可能重复");
        }

        GenericAccountResponse genericAccountResponse =
                new GenericAccountResponse(accountDto);

        return genericAccountResponse;
    }

    //更新密码



    //更改email



    //改名字



    //使用id查询账户



}
