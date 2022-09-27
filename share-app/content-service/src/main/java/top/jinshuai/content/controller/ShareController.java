package top.jinshuai.content.controller;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
//import com.alibaba.csp.sentinel.slots.block.BlockException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jinshuai.content.common.ResponseResult;
import top.jinshuai.content.service.ShareService;

/**
 * @description:
 * @author: syhan
 * @create: 2022-09-06
 **/

@RestController
@Slf4j
@RefreshScope
@RequestMapping(value = "/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {

    private final ShareService shareService;

    // private final UserService userService;

    @GetMapping("/all")
    public ResponseResult getAllShares() {
        return ResponseResult.success(shareService.findAll());
    }

    //@GetMapping("{id}")
    //ResponseResult getShareById(@PathVariable Integer id) {
    //    Share share = shareService.findById(id);
    //    Integer userId = share.getUserId();
    //    ResponseResult res = userService.getUser(userId);
    //    String jsonString = JSONObject.toJSONString(res.getData());
    //    JSONObject obj = JSONObject.parseObject(jsonString);
    //    User user = JSONObject.toJavaObject(obj, User.class);
    //    ShareDto shareDTO = ShareDto.builder().share(share).nickname(user.getNickname()).avatar(user.getAvatar()).build();
    //    return ResponseResult.success(shareDTO);
    //}
}
