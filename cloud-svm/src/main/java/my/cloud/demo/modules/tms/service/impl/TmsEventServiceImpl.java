package my.cloud.demo.modules.tms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;

import my.cloud.demo.modules.tms.mapper.TmsEventMapper;
import my.cloud.demo.modules.tms.model.TmsEvent;
import my.cloud.demo.modules.tms.service.TmsEventService;
import org.springframework.stereotype.Service;


/**
 * 事件管理Service實現類
 */
@Service
@Slf4j
public class TmsEventServiceImpl extends ServiceImpl<TmsEventMapper, TmsEvent> implements TmsEventService {

    @Override
    public Page<TmsEvent> list(String keyword, String beginTime, String endTime, Integer pageSize, Integer pageNum) {

        Page<TmsEvent> page = new Page<>(pageNum, pageSize);
        QueryWrapper<TmsEvent> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<TmsEvent> lambda = wrapper.lambda();
        lambda.orderByDesc(TmsEvent::getCreateTime);

        log.info("createTime  between : {} and {} ",beginTime,endTime);

        if (StrUtil.isNotEmpty(keyword)) {
            lambda.like(TmsEvent::getEventName, keyword);
            lambda.or().like(TmsEvent::getVehicleName, keyword);
            lambda.or().like(TmsEvent::getDeviceName, keyword);
            lambda.or().like(TmsEvent::getObjectId, keyword);
        }

        if (StrUtil.isNotEmpty(beginTime)) {
            lambda.gt(TmsEvent::getCreateTime, beginTime);
        }

        if (StrUtil.isNotEmpty(endTime)) {
            lambda.lt(TmsEvent::getCreateTime, endTime);
        }
        return page(page, wrapper);
    }

}