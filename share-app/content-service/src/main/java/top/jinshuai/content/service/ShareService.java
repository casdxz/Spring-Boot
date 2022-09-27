package top.jinshuai.content.service;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
import top.jinshuai.content.domain.entity.Share;

import java.util.List;

/**
 * @description:
 * @author: syhan
 * @create: 2022-09-06
 **/

public interface ShareService {
    /**
     * @return share
     */
    //Share findById(Integer id);

    List<Share> findAll();
}
