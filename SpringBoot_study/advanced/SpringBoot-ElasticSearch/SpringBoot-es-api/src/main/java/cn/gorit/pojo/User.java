package cn.gorit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Classname User
 * @Description TODO
 * @Date 2020/10/21 19:55
 * @Created by CodingGorit
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private String name;
    private int age;
}
