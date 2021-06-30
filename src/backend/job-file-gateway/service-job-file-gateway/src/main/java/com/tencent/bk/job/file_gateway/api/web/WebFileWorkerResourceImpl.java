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

package com.tencent.bk.job.file_gateway.api.web;

import com.tencent.bk.job.common.model.ServiceResponse;
import com.tencent.bk.job.file_gateway.consts.WorkerSelectScopeEnum;
import com.tencent.bk.job.file_gateway.model.dto.FileWorkerDTO;
import com.tencent.bk.job.file_gateway.model.resp.web.FileWorkerVO;
import com.tencent.bk.job.file_gateway.service.FileWorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Slf4j
public class WebFileWorkerResourceImpl implements WebFileWorkerResource {

    private final FileWorkerService fileWorkerService;

    @Autowired
    public WebFileWorkerResourceImpl(FileWorkerService fileWorkerService) {
        this.fileWorkerService = fileWorkerService;
    }

    @Override
    public ServiceResponse<List<FileWorkerVO>> listFileWorker(String username, Long appId,
                                                              WorkerSelectScopeEnum workerSelectScope) {
        List<FileWorkerDTO> fileWorkerDTOList = fileWorkerService.listFileWorker(username, appId, workerSelectScope);
        if (fileWorkerDTOList == null || fileWorkerDTOList.size() == 0) {
            return ServiceResponse.buildSuccessResp(Collections.emptyList());
        }
        List<FileWorkerVO> fileWorkerVOList =
            fileWorkerDTOList.parallelStream().map(FileWorkerDTO::toVO).collect(Collectors.toList());
        return ServiceResponse.buildSuccessResp(fileWorkerVOList);
    }
}