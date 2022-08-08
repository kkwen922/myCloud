package my.cloud.demo.modules.ims.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import my.cloud.demo.modules.ims.mapper.ImsEventMapper;
import my.cloud.demo.modules.ims.model.ImsEvent;
import my.cloud.demo.modules.ims.service.ImsEventService;
import org.springframework.stereotype.Service;


/**
 * 事件管理Service實現類
 */
@Service
@Slf4j
public class ImsEventServiceImpl extends ServiceImpl<ImsEventMapper, ImsEvent> implements ImsEventService {


    @Override
    public Page<ImsEvent> list(String keyword, String beginTime, String endTime, Integer pageSize, Integer pageNum) {

        Page<ImsEvent> page = new Page<>(pageNum, pageSize);
        QueryWrapper<ImsEvent> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<ImsEvent> lambda = wrapper.lambda();
        lambda.orderByDesc(ImsEvent::getEventTime);

        log.info("createTime  between : {} and {} ",beginTime,endTime);

        if (StrUtil.isNotEmpty(keyword)) {
            lambda.like(ImsEvent::getEventType, keyword);
            lambda.or().like(ImsEvent::getOrgName, keyword);
            lambda.or().like(ImsEvent::getDeviceName, keyword);
            lambda.or().like(ImsEvent::getProduct, keyword);
        }

        if (StrUtil.isNotEmpty(beginTime)) {
            lambda.gt(ImsEvent::getEventTime, beginTime);
        }

        if (StrUtil.isNotEmpty(endTime)) {
            lambda.lt(ImsEvent::getEventTime, endTime);
        }
        return page(page, wrapper);
    }

}
