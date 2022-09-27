package top.jinshuai.content.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @description:
 * @author: syhan
 * @create: 2022-09-06
 **/

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private Integer id;

    private String mobile;

    private String password;

    private String nickname;

    private String avatar;
}
