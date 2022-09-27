package top.jinshuai.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jinshuai.content.domain.entity.Share;

/**
 * @description:
 * @author: syhan
 * @create: 2022-09-06
 **/

public interface ShareRepository extends JpaRepository<Share, Integer> {
}
