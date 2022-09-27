package top.jinshuai.notice.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.jinshuai.notice.entity.Notice;
import top.jinshuai.notice.repository.NoticeRepository;
import top.jinshuai.notice.service.NoticeService;

import javax.annotation.Resource;

/**
 * @description:
 * @author: syhan
 * @create: 2022-09-25
 **/

@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeRepository noticeRepository;

    @Override
    public Notice getLatestNotice() {
        Sort sort = Sort.by("createTime").descending();
        return noticeRepository.findByShowFlag(true, sort).get(0);
    }
}
