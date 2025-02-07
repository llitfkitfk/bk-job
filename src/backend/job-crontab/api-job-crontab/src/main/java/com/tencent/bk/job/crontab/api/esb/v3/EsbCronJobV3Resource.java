/*
 * Tencent is pleased to support the open source community by making BK-JOB蓝鲸智云作业平台 available.
 *
 * Copyright (C) 2021 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-JOB蓝鲸智云作业平台 is licensed under the MIT License.
 *
 * License for BK-JOB蓝鲸智云作业平台:
 * --------------------------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package com.tencent.bk.job.crontab.api.esb.v3;

import com.tencent.bk.job.common.esb.model.EsbResp;
import com.tencent.bk.job.common.esb.model.job.v3.EsbPageDataV3;
import com.tencent.bk.job.crontab.model.esb.v3.request.EsbGetCronDetailV3Request;
import com.tencent.bk.job.crontab.model.esb.v3.request.EsbGetCronListV3Request;
import com.tencent.bk.job.crontab.model.esb.v3.request.EsbSaveCronV3Request;
import com.tencent.bk.job.crontab.model.esb.v3.request.EsbUpdateCronStatusV3Request;
import com.tencent.bk.job.crontab.model.esb.v3.response.EsbCronInfoV3Response;
import org.springframework.web.bind.annotation.*;

import static com.tencent.bk.job.common.i18n.locale.LocaleUtils.COMMON_LANG_HEADER;

/**
 * @since 26/2/2020 16:24
 */
@RequestMapping("/esb/api/v3")
@RestController
public interface EsbCronJobV3Resource {

    /**
     * 获取定时任务列表
     *
     * @param lang    用户语言
     * @param request 查询请求
     * @return 定时任务列表
     */
    @PostMapping("/get_cron_list")
    EsbResp<EsbPageDataV3<EsbCronInfoV3Response>> getCronList(
        @RequestHeader(value = COMMON_LANG_HEADER, required = false) String lang,
        @RequestBody EsbGetCronListV3Request request);

    /**
     * 获取定时任务详情
     *
     * @param lang    用户语言
     * @param request 查询请求
     * @return 定时任务详情
     */
    @PostMapping("/get_cron_detail")
    EsbResp<EsbCronInfoV3Response> getCronDetail(
        @RequestHeader(value = COMMON_LANG_HEADER, required = false) String lang,
        @RequestBody EsbGetCronDetailV3Request request);

    /**
     * 更新定时任务状态
     *
     * @param lang    用户语言
     * @param request 更新请求
     * @return 定时任务详情
     */
    @PostMapping(value = "/update_cron_status")
    EsbResp<EsbCronInfoV3Response> updateCronStatus(
        @RequestHeader(value = COMMON_LANG_HEADER, required = false) String lang,
        @RequestBody EsbUpdateCronStatusV3Request request);

    /**
     * 更新定时任务详情
     *
     * @param lang    用户语言
     * @param request 更新请求
     * @return 定时任务详情
     */
    @PostMapping(value = "/save_cron")
    EsbResp<EsbCronInfoV3Response> saveCron(
        @RequestHeader(value = COMMON_LANG_HEADER, required = false) String lang,
        @RequestBody EsbSaveCronV3Request request);
}
