package me.kdshim.kdd_j.config

import org.junit.jupiter.api.extension.AfterTestExecutionCallback
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.beans.factory.annotation.Value
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BaseExtension : BeforeTestExecutionCallback, AfterTestExecutionCallback {
    @Value("\${rootName}")
    var rootName: String? = null
    @Throws(Exception::class)
    override fun beforeTestExecution(context: ExtensionContext) {
        val className = context.requiredTestClass.name
        val methodName = context.requiredTestMethod.name
        val store = context.getStore(ExtensionContext.Namespace.create(className, methodName))
        val sb = StringBuilder()
        sb.append(context.displayName + " STARTED AT : ")
            .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        println("************************ KD's Test ************************")
        println(sb)

        //toCheck runTime
        store.put("TEST_START_TIME", System.currentTimeMillis())
    }

    @Throws(Exception::class)
    override fun afterTestExecution(context: ExtensionContext) {
        val className = context.requiredTestClass.name
        val methodName = context.requiredTestMethod.name
        val store = context.getStore(ExtensionContext.Namespace.create(className, methodName))
        val test_start_time = store.remove("TEST_START_TIME", Long::class.javaPrimitiveType)
        println(context.displayName + " ENDED IN " + (System.currentTimeMillis() - test_start_time) + " sec")
        println("***********************************************************")
    }
}