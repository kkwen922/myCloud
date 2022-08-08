package my.cloud.demo.modules.ims.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import my.cloud.demo.modules.ims.mapper.ImsInventoryMapper;
import my.cloud.demo.modules.ims.model.ImsInventory;
import my.cloud.demo.modules.ims.service.ImsInventoryService;
import org.springframework.stereotype.Service;


/**
 * 事件管理Service實現類
 */
@Service
@Slf4j
public class ImsInventoryServiceImpl extends ServiceImpl<ImsInventoryMapper, ImsInventory> implements ImsInventoryService {


    @Override
    public Page<ImsInventory> list(String keyword, String beginTime, String endTime , Integer pageSize, Integer pageNum) {

        Page<ImsInventory> page = new Page<>(pageNum, pageSize);
        QueryWrapper<ImsInventory> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<ImsInventory> lambda = wrapper.lambda();
        lambda.orderByDesc(ImsInventory::getCreateTime);

        log.info("createTime  between : {} and {} ",beginTime,endTime);

        if (StrUtil.isNotEmpty(keyword)) {
            lambda.like(ImsInventory::getOrgName, keyword);
            lambda.or().like(ImsInventory::getDeviceName, keyword);
            lambda.or().like(ImsInventory::getProduct, keyword);
        }

        if (StrUtil.isNotEmpty(beginTime)) {
            lambda.gt(ImsInventory::getCreateTime, beginTime);
        }

        if (StrUtil.isNotEmpty(endTime)) {
            lambda.lt(ImsInventory::getCreateTime, endTime);
        }

        return page(page, wrapper);
    }

}
