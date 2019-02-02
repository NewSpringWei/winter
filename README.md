# Winter SnowMan(WSM)

用于个人练习Java项目的资源，实现前后端分离

## 基本说明

1. 技术选型
    - 选用Spring Boot搭建服务框架
    - 选用Mybatis作为数据访问持久层
    - 选用Mybaits Generator用于生成数据库映射文件
    - 选用PostgreSQL作为主业务数据库
    - 选用Redis作为缓存数据库
    - 选用RabbitMQ作为应用级数据总线
    - 选用Nginx作为服务的反向代理
2. 设计方向
    - 创建相对独立的系统服务，有一个基础系统服务，所有拓展系统服务都依赖于此，各拓展服务之间脱离硬性依赖。若拓展服务之间产生交互则依托于数据总线做关键数据交换。
3. 系统服务列表
    - 基础服务
        - 系统参数
        - 系统用户
        - 系统角色
        - 系统权限
        - 组织结构
        - 系统日志
        - 文件存储

## 实现步骤

1. 搭建后端服务，集成系统运行插件。

2. 基础服务的数据结构的设计。

3. 搭建前端框架，完成系统认证，基础功能的界面开发。
