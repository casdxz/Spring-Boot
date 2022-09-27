package top.jinshuai.notice.service;

import top.jinshuai.notice.entity.Notice;

/**
 * @description:
 * @author: syhan
 * @create: 2022-09-25
 **/

public interface NoticeService {
    /**
     * 获取最新通知
     *
     * @return notice
     */
    Notice getLatestNotice();
}

