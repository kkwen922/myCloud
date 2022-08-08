package my.cloud.demo.modules.dms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import my.cloud.demo.modules.dms.dto.DmsDeviceParam;
import my.cloud.demo.modules.dms.model.DmsDevice;


/**
 * 設備管理Service
 */
public interface DmsDeviceService extends IService<DmsDevice> {
    /**
     * 根據設備編號獲得該設備資訊
     */
    DmsDevice getDeviceByDeviceSn(String deviceSn);

    /**
     * 新增設備
     */
    DmsDevice create(DmsDeviceParam dmsDeviceParam);

    /**
     * 根據設備名稱或設備編號分頁查詢設備資訊
     */
    Page<DmsDevice> list(String keyword,  Integer pageSize, Integer pageNum);

    /**
     * 修改指定設備資訊
     */
    boolean update(Long id, DmsDevice device);

    /**
     * 删除指定設備資訊
     */
    boolean delete(Long id);


}
