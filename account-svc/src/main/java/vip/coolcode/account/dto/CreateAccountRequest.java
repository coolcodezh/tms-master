package vip.coolcode.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/*封装请求数据*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAccountRequest {

    @NotNull(message = "名字不能为空")
    private String name;
    @Email(message = "不合法的Email格式")
    private String email;

    //自己验证电话号码是否合法
    private String phoneNumber;


}
