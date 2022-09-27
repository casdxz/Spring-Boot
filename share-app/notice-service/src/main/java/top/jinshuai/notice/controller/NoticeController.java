package top.jinshuai.notice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jinshuai.notice.common.ResponseResult;
import top.jinshuai.notice.common.ResultCode;
import top.jinshuai.notice.service.NoticeService;


import javax.annotation.Resource;

/**
 * @description:
 * @author: syhan
 * @create: 2022-09-06
 **/

@RestController
@RequestMapping(value = "/notices")
@RefreshScope
@Slf4j
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    @Value("${disableNotNoticeRequest:false}")
    private Boolean disableNotice;

    @GetMapping("/latest")
    public ResponseResult getNotice() {
        if (disableNotice){
            log.info("暂停公告服务");
            return ResponseResult.failure(ResultCode.INTERFACE_FORBID_VISIT);
        }
        var notice = noticeService.getLatestNotice();
        if (notice!= null) {
            return ResponseResult.success(notice);
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}

