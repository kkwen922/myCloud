package my.cloud.demo.modules.ims.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import my.cloud.demo.modules.ims.mapper.ImsSalesMapper;
import my.cloud.demo.modules.ims.model.ImsSales;
import my.cloud.demo.modules.ims.service.ImsSalesService;
import org.springframework.stereotype.Service;


/**
 * 事件管理Service實現類
 */
@Service
@Slf4j
public class ImsSalesServiceImpl extends ServiceImpl<ImsSalesMapper, ImsSales> implements ImsSalesService {


    @Override
    public Page<ImsSales> list(String keyword, String beginTime, String endTime , Integer pageSize, Integer pageNum) {

        Page<ImsSales> page = new Page<>(pageNum, pageSize);
        QueryWrapper<ImsSales> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<ImsSales> lambda = wrapper.lambda();
        lambda.orderByDesc(ImsSales::getSaleTime);

        log.info("salesTime  between : {} and {} ",beginTime,endTime);

        if (StrUtil.isNotEmpty(keyword)) {
            lambda.like(ImsSales::getOrgName, keyword);
            lambda.or().like(ImsSales::getDeviceName, keyword);
            lambda.or().like(ImsSales::getProduct, keyword);
        }

        if (StrUtil.isNotEmpty(beginTime)) {
            lambda.gt(ImsSales::getSaleTime, beginTime);
        }

        if (StrUtil.isNotEmpty(endTime)) {
            lambda.lt(ImsSales::getSaleTime, endTime);
        }
        return page(page, wrapper);
    }

}
