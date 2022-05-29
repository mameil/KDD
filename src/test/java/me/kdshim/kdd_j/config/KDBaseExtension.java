package me.kdshim.kdd_j.config;


import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KDBaseExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    @Value("${rootName}")
    String rootName;

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        String className = context.getRequiredTestClass().getName();
        String methodName = context.getRequiredTestMethod().getName();

        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(className, methodName));
        StringBuilder sb = new StringBuilder();
        sb.append(context.getDisplayName() + " STARTED AT : ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("************************ KD's Test ************************");
        System.out.println(sb);

        //toCheck runTime
        store.put("TEST_START_TIME", System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        String className = context.getRequiredTestClass().getName();
        String methodName = context.getRequiredTestMethod().getName();

        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(className, methodName));

        Long test_start_time = store.remove("TEST_START_TIME", long.class);

        System.out.println(context.getDisplayName() + " ENDED IN "+(System.currentTimeMillis() - test_start_time) + " sec");
        System.out.println("***********************************************************");

    }
}
