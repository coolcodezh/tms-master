package vip.coolcode.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/*响应结果的数据封装*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

    private String id;
    private String name;
    private String email;
    private boolean confirmedAndActive;
    private Instant memberSince;
    private boolean support;
    private String phoneNumber;
    private String photoUrl;




}
