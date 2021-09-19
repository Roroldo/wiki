package com.roroldo.wiki.job;

 import com.roroldo.wiki.service.DocService;
 import com.roroldo.wiki.util.SnowFlake;
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 import org.slf4j.MDC;
 import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

 /**
  * 电子书和文档数据同步的定时器
  * @author 落霞不孤
  */
 @Component
 public class DocJob {

    private static final Logger LOG = LoggerFactory.getLogger(DocJob.class);

    @Resource
    private SnowFlake snowFlake;

    @Resource
    private DocService docService;

    /**
     * 每 30 秒更新电子书信息
     * cron 表达式在线生成器 https://cron.qqe2.com/
     */
    @Scheduled(cron = "3/9 * * * * ? ")
    public void cron() {
        // 增加日志流水号
        MDC.put("LOG_ID", String.valueOf(snowFlake.nextId()));
        LOG.info("开始更新电子书下的文档数据");
        long start = System.currentTimeMillis();
        docService.updateEbookInfo();
        LOG.info("文档数据更新结束, 耗时: {}毫秒",System.currentTimeMillis() - start);
    }
 }
