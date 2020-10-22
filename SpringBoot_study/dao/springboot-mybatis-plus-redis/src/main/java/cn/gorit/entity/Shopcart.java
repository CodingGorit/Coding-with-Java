package cn.gorit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Gorit
 * @since 2020-10-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Shopcart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "shop_no", type = IdType.AUTO)
    private Integer shopNo;

    private Integer pid;

    private Integer uid;

    private Integer num;


}
