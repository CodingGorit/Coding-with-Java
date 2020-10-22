package cn.gorit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Content
 * @Description TODO
 * @Date 2020/10/22 18:38
 * @Created by CodingGorit
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    private String title;
    private String img;
    private String price;
    // 自行添加属性
}
