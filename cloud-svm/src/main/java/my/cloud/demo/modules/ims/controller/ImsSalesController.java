package my.cloud.demo.modules.ims.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import my.cloud.demo.common.api.CommonPage;
import my.cloud.demo.common.api.CommonResult;
import my.cloud.demo.modules.ims.model.ImsSales;
import my.cloud.demo.modules.ims.service.ImsSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 銷售管理
 */
@Controller
@Api(tags = "ImsSalesController", description = "銷售管理")
@RequestMapping("/sales")
@Slf4j
public class ImsSalesController {

    @Autowired
    private ImsSalesService imsSalesService;


    @ApiOperation("依據銷售欄位值，獲得Sles相關資訊之分頁列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ImsSales>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                   @RequestParam(required = false) String beginTime, //起日
                                                   @RequestParam(required = false) String endTime, //迄日
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<ImsSales> salesList = imsSalesService.list(keyword,beginTime,endTime, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(salesList));
    }


}
