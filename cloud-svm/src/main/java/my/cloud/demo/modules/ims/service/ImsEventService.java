package my.cloud.demo.modules.ims.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import my.cloud.demo.modules.ims.model.ImsEvent;

/**
 * 設備管理Service
 */
public interface ImsEventService extends IService<ImsEvent> {

    /**
     * 根據事件相關欄位，分頁查詢事件資訊
     */
    Page<ImsEvent> list(String keyword,String beginTime, String endTime,  Integer pageSize, Integer pageNum);



}
