package com.gqx.cloud.serverfive.processor;

import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;

@Component
public class TestBasicProcessor implements BasicProcessor {

    @Override
    public ProcessResult process(TaskContext taskContext) throws Exception {
        System.out.println("面对疾风咯~~~~~~~~~~");
        return new ProcessResult(true,"面对疾风咯~~~~~~~~~~");
    }

}
