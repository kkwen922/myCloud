package my.cloud.demo.modules.dms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import my.cloud.demo.modules.dms.dto.DmsDeviceParam;
import my.cloud.demo.modules.dms.mapper.DmsDeviceMapper;
import my.cloud.demo.modules.dms.model.DmsDevice;
import my.cloud.demo.modules.dms.service.DmsDeviceService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 設備管理Service實現類
 */
@Service
@Slf4j
public class DmsDeviceServiceImpl extends ServiceImpl<DmsDeviceMapper, DmsDevice> implements DmsDeviceService {

    @Override
    public DmsDevice getDeviceByDeviceSn(String deviceSn) {
        QueryWrapper<DmsDevice> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(DmsDevice::getDeviceSn, deviceSn);
        List<DmsDevice> deviceList = list(wrapper);
        if (deviceList != null && deviceList.size() > 0) {
            DmsDevice device = deviceList.get(0);
            return device;
        }
        return null;
    }

    @Override
    public DmsDevice create(DmsDeviceParam dmsDeviceParam) {
        DmsDevice dmsDevice = new DmsDevice();
        BeanUtils.copyProperties(dmsDeviceParam, dmsDevice);
        dmsDevice.setCreateTime(new Date());
        dmsDevice.setStatus(1);

        //查詢是否有相同編號的設備
        QueryWrapper<DmsDevice> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(DmsDevice::getDeviceSn, dmsDevice.getDeviceSn());
        List<DmsDevice> deviceList = list(wrapper);
        if (deviceList.size() > 0) {
            return null;
        }
        baseMapper.insert(dmsDevice);
        return dmsDevice;
    }

    @Override
    public Page<DmsDevice> list(String keyword, Integer pageSize, Integer pageNum) {

        Page<DmsDevice> page = new Page<>(pageNum, pageSize);
        QueryWrapper<DmsDevice> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<DmsDevice> lambda = wrapper.lambda();
        lambda.orderByAsc(DmsDevice::getOrgId,DmsDevice::getDeviceName);

        if (StrUtil.isNotEmpty(keyword)) {
            lambda.like(DmsDevice::getDeviceSn, keyword);
            lambda.or().like(DmsDevice::getDeviceName, keyword);
        }
        return page(page, wrapper);
    }

    @Override
    public boolean update(Long id, DmsDevice device) {
        device.setId(id);
        DmsDevice rawDevice = getById(id);
        if (id == device.getId()) {
            boolean success = updateById(device);
            return success;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        boolean success = removeById(id);
        return success;
    }
}
