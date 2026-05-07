# Express Locker Backend

语言： [English](README.md) | 简体中文

一个 Java / Spring Boot 快递柜物流后端练习项目，覆盖用户、快递员、快递柜、柜门、寄存订单、寄件订单、取件码和基础管理流程。

## 项目覆盖范围

| 方向 | 已包含模块 |
| --- | --- |
| 用户流程 | 用户名登录、注册、修改密码、实名认证、管理员登录 |
| 快递柜操作 | 快递柜列表、新增/删除、状态切换、可用柜门查询 |
| 寄存订单 | 按柜门寄存包裹、按取件码取件 |
| 快递员订单 | 快递员寄件、按快递员查询订单、按寄件码取件 |
| 数据持久化 | MyBatis-Plus mapper 和 XML mapper，面向 MySQL 数据访问 |
| 缓存实践 | Redis 配置和 Caffeine 依赖，用于缓存相关练习 |

## 技术栈

- Java 8
- Spring Boot 2.6
- Spring Web
- MyBatis-Plus
- MySQL connector
- Redis
- Maven
- JUnit 5 / Spring Boot test

## 项目结构

```text
express-locker-backend/
├─ src/main/java/com/yexuhang/express/
│  ├─ bean/                 # 实体类
│  ├─ config/               # 通用返回结构、Redis 配置、代码生成辅助
│  ├─ controller/           # REST 控制器
│  ├─ dto/                  # 请求 DTO
│  ├─ mapper/               # MyBatis-Plus mapper 接口
│  └─ service/              # service 接口和实现
├─ src/main/java/com/yexuhang/express/mapper/xml/
├─ src/test/java/com/yexuhang/express/
├─ pom.xml
└─ README.md
```

## API 概览

| Controller | Base path | 示例接口 |
| --- | --- | --- |
| `UsersController` | `/users` | `POST /login/username`, `POST /register`, `POST /admin/login`, `GET /details` |
| `CabinetsController` | `/cabinets` | `POST /all`, `POST /add`, `POST /delete`, `POST /setStatus` |
| `CabinetDoorsController` | `/cabinetDoors` | `GET /{cabinetId}/{sizeType}/availableDoors` |
| `StorageOrdersController` | `/storageOrders` | `POST /storeExpress`, `POST /pickExpress` |
| `SendExpressOrdersController` | `/sendExpressOrders` | `POST /sendExpress`, `GET /{courierId}/orders`, `POST /pickExpress` |
| `ExpressOrdersController` | `/expressOrders` | `POST /{cabinetId}/getAllExpressOrders`, `POST /pickExpressOrderByPickCode`, `POST /addExpressOrder` |

## 快速开始

前置要求：

- JDK 8 或更高版本
- Maven 3.8 或更高版本
- 如需完整本地运行，需要准备 MySQL 和 Redis

运行测试：

```bash
mvn test
```

构建项目：

```bash
mvn package
```

添加本地数据库和 Redis 配置后启动应用：

```bash
mvn spring-boot:run
```

仓库不会提交生产凭据或本地数据库连接串。真实部署时，请把环境相关配置放在 Git 之外。

## 当前状态

这是一个学习和作品集后端项目，不是已经打包好的生产服务。它适合用来查看 Spring Boot controller/service/mapper 分层、MyBatis-Plus 使用方式，以及物流场景 API 练习。

## 贡献

欢迎提交小范围改进，适合优先补的方向：

- 增加脱敏后的示例配置
- 记录数据库表结构假设
- 增加 controller/service 测试
- 改进参数校验和错误提示
- 为部署示例收紧 CORS 和安全默认值

提交 PR 前请先阅读 [CONTRIBUTING.md](CONTRIBUTING.md)。

## Support

如果这个项目帮你节省了时间，可以在这里支持后续维护：[Buy Me a Coffee](https://www.buymeacoffee.com/aolingge)。

## License

MIT
