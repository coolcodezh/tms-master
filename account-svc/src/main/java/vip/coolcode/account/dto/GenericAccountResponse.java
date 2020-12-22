package vip.coolcode.account.dto;

import lombok.*;
import vip.coolcode.common.api.BaseResponse;

/* 响应的基类是BaseReponse, 此类是BaseResponse的扩展，专用到Account服务的响应 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GenericAccountResponse extends BaseResponse {

    private AccountDto accountDto;

}
