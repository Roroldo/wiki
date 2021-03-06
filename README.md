# Spring Boot + Vue3 前后端分离 wiki 知识库

> 访问地址：http://8.131.69.234/
>
> * 账号：Roroldo
> * 密码：123456

## 一、项目介绍

![image-20210919165228809](https://gitee.com/Roroldo/ImgRepo/raw/master/image-20210919165228809.png)

wiki 在线知识库，适用于个人或团队作为日常学习记录的 web 端软件。实现的功能有：

* 电子书分类管理：支持大分类下还有其他小分类
* 电子书管理：电子书的增加、删除、更新操作，包括电子书内容的文档管理。
* 用户管理：登录、修改、重置密码和删除。
* 电子书的数据快照：定时任务统计电子书的浏览信息，展示在首页，数据存在短暂的延时。




## 二、项目用的技术

本项目是一个前后端分离的项目，后端主要采用：

* Spring Boot + MyBatis + Redis

前端主要采用：

* Vue + Echarts + wangEditor + Ant Design 

部署：

* Docker + Nginx + 阿里云服务器





## 三、项目总结

* 使用 CorsConfig 实现 WebMvcConfigurer 接口的 addCorsMappings 方法解决前后端跨域的问题
* SpringBoot 的参数校验，全局异常的统一处理
* SpringBoot 的 AOP 技术统计接口的耗时，过滤敏感数据
* SpringBoot 的拦截器进行权限校验，当用户没有登录的情况下，拦截非法操作
* 使用雪花算法作为分布式数据库表的主键 id 生成，也可以作为日志的流水帐号
* 使用定时任务定时汇总电子书文档的浏览情况，生成电子书的数据快照，展示给用户
* 使用 WebSocket 作为客户端和服务端的数据通信，在某一用户点赞文档时，所有在线用户都会收到点赞消息
* 使用 redis + token 实现单点登录
* 前后端都对用户密码进行加密传输保存，防止被截取数据
* 使用日志详细记录项目的运行状态


