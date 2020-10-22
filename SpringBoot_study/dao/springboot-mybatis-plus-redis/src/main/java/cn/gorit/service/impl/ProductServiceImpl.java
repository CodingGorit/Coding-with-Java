package cn.gorit.service.impl;

import cn.gorit.entity.Product;
import cn.gorit.mapper.ProductMapper;
import cn.gorit.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gorit
 * @since 2020-10-19
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
