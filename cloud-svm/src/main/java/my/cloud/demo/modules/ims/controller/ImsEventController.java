package my.cloud.demo.modules.ims.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import my.cloud.demo.common.api.CommonPage;
import my.cloud.demo.common.api.CommonResult;
import my.cloud.demo.modules.ims.model.ImsEvent;
import my.cloud.demo.modules.ims.service.ImsEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 事件管理
 */
@Controller
@Api(tags = "ImsEventController", description = "事件管理")
@RequestMapping("/event")
@Slf4j
public class ImsEventController {

    @Autowired
    private ImsEventService imsEventService;


    @ApiOperation("依據事件欄位值，獲得事件相關資訊之分頁列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ImsEvent>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                   @RequestParam(required = false) String beginTime, //起日
                                                   @RequestParam(required = false) String endTime, //迄日
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<ImsEvent> eventList = imsEventService.list(keyword,beginTime,endTime, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(eventList));
    }


}
