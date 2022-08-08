package my.cloud.demo.modules.tms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import my.cloud.demo.modules.tms.model.TmsEvent;

/**
 * 設備管理Service
 */
public interface TmsEventService extends IService<TmsEvent> {

    /**
     * 根據事件相關欄位，分頁查詢事件資訊
     */
    Page<TmsEvent> list(String keyword,String beginTime, String endTime,  Integer pageSize, Integer pageNum);



}
