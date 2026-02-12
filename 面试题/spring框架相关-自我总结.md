# Spring 框架核心面试题深度解析与示例

## 1. Spring 的两大核心思想是什么？

**IOC（控制反转）** 和 **AOP（面向切面编程）** 是 Spring 框架的两大核心思想。

- **IOC**：将对象的创建和依赖关系的管理从应用程序代码中转移到容器中，实现解耦
- **AOP**：将横切关注点（如日志、事务等）从业务逻辑中分离出来

**示例说明**：
```java
// 传统方式：直接创建依赖
public class UserService {
    private UserDao userDao = new UserDaoImpl(); // 紧耦合
}

// IOC方式：依赖由容器注入
@Service
public class UserService {
    @Autowired
    private UserDao userDao;  // 由Spring容器注入，松耦合
}

// AOP示例：声明一个切面
@Aspect
@Component
public class LoggingAspect {
    
    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("方法执行前: " + joinPoint.getSignature().getName());
    }
}
```

**面试回答**：  
Spring 的两大核心是 IOC 和 AOP。IOC 实现控制反转，将对象的创建和依赖管理交给容器，降低耦合度；AOP 实现面向切面编程，将横切关注点（如日志、事务）从业务逻辑中分离，提高代码复用性和可维护性。

---

## 2. 说说你对 IOC 的理解

IOC 是一种设计思想，将对象的控制权从程序员手中转移到 Spring 容器中。

**示例说明**：
```java
// 没有IOC时，我们需要自己管理依赖
public class OrderService {
    private PaymentService paymentService;
    
    public OrderService() {
        this.paymentService = new PaymentService(); // 紧耦合
    }
}

// 使用IOC后
@Service
public class OrderService {
    @Autowired
    private PaymentService paymentService; // 松耦合
}
```

**优点**：
- 降低耦合度，提高代码可维护性
- 便于单元测试，可以轻松注入mock对象
- 提高代码复用性

**面试回答**：  
IOC（控制反转）是一种设计思想，用于解决程序间的耦合问题。传统开发中对象由程序员直接创建，控制权在开发者手中。而在 Spring 中，对象的创建权交给 Spring 容器，实现控制反转，从而更便捷地管理对象依赖，提高代码的可维护性和可测试性。

---

## 3. 什么是 AOP？在你项目中哪些地方能体现？

AOP 将横切关注点模块化，常见的应用场景包括日志记录、事务管理、权限校验等。

**示例说明**：
```java
// 1. 日志记录
@Aspect
@Component
public class LoggingAspect {
    
    @Around("@annotation(com.example.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " 执行时间: " + executionTime + "ms");
        return result;
    }
}

// 2. 事务管理
@Service
public class UserService {
    
    @Transactional
    public User createUser(User user) {
        // 业务逻辑
        return userRepository.save(user);
    }
}

// 3. 权限校验
@Aspect
@Component
public class SecurityAspect {
    
    @Before("@annotation(requiresPermission)")
    public void checkPermission(RequiresPermission requiresPermission) {
        if (!hasPermission(requiresPermission.value())) {
            throw new SecurityException("权限不足");
        }
    }
}
```

**面试回答**：  
AOP（面向切面编程）是面向对象编程的补充，用于**抽取与业务无关**但**影响多个对象的公共行为**（如日志、事务、权限等），并将其封装为可重复用的"切面"，减少重复代码，降低耦合，提高可维护性。在我的项目中，AOP 主要用于日志记录、事务管理和权限校验等场景。 

---

## 4. 讲讲 Spring 启动过程是什么样的？

Spring 启动过程本质是 **IoC 容器的初始化过程**，可分为以下几个核心步骤：

1. **加载配置**：加载 `applicationContext.xml` 或 Java Config 配置类
2. **创建容器**：初始化 `ApplicationContext`，管理所有 Bean
3. **扫描组件**：扫描指定包，识别 `@Component`、`@Service` 等注解
4. **实例化 Bean**：通过反射创建 Bean 实例
5. **依赖注入**：根据 `@Autowired` 或 XML 配置注入依赖
6. **AOP 处理**：如有 AOP 配置，生成代理对象并织入切面逻辑
7. **生命周期回调**：执行 `@PostConstruct` 等初始化方法
8. **启动完成**：容器就绪，可对外提供服务

**示例说明**：
```java
// Spring Boot 启动类
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// 配置类
@Configuration
@ComponentScan("com.example")
public class AppConfig {
    
    @Bean
    public DataSource dataSource() {
        // 配置数据源
        return new HikariDataSource();
    }
}
```

**面试回答**：  
Spring 启动过程是 IoC 容器的初始化过程，主要包括：加载配置、创建容器、扫描组件、实例化 Bean、依赖注入、AOP 处理、生命周期回调和启动完成。对于 Spring Boot，它在标准 Spring 流程之上增加了自动配置和嵌入式 Web 容器启动等机制。

---

## 5. Spring 框架中的单例 Bean 是线程安全的吗？

**不是线程安全的**，因为 Spring 框架并没有对单例 Bean 进行多线程的封装处理。

**示例说明**：
```java
@Service
public class CounterService {
    private int count = 0; // 共享状态，非线程安全
    
    public void increment() {
        count++; // 多线程环境下会出现问题
    }
}

// 解决方案
@Service
public class CounterService {
    private final AtomicInteger count = new AtomicInteger(0); // 使用线程安全类
    
    public void increment() {
        count.incrementAndGet(); // 线程安全
    }
}

// 或者使用ThreadLocal
@Service
public class UserContext {
    private static final ThreadLocal<User> currentUser = new ThreadLocal<>();
    
    public void setCurrentUser(User user) {
        currentUser.set(user);
    }
    
    public User getCurrentUser() {
        return currentUser.get();
    }
}
```

**面试回答**：  
Spring 框架中的单例 Bean 不是线程安全的，因为 **Spring 没有对单例 Bean 进行多线程封装**。常见的解决方案有：1) 尽量避免定义可变的成员变量；2) 使用 ThreadLocal 存储可变状态；3) 使用线程安全类如 AtomicInteger。

---

## 6. Spring 循环依赖了解吗？如何解决？

循环依赖是指多个 Bean 互相依赖，如 A→B→C→A。Spring 通过**三级缓存**解决单例 Bean 的循环依赖。

**示例说明**：
```java
// 循环依赖示例
@Service
public class ServiceA {
    @Autowired
    private ServiceB serviceB;
}

@Service
public class ServiceB {
    @Autowired
    private ServiceC serviceC;
}

@Service
public class ServiceC {
    @Autowired
    private ServiceA serviceA; // 循环依赖
}

// Spring 三级缓存模拟
public class SpringContainer {
    // 一级缓存：完整的Bean
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    // 二级缓存：早期的Bean引用
    private Map<String, Object> earlySingletonObjects = new HashMap<>();
    // 三级缓存：Bean工厂
    private Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();
    
    public Object getBean(String name) {
        Object bean = singletonObjects.get(name);
        if (bean == null) {
            bean = earlySingletonObjects.get(name);
            if (bean == null) {
                ObjectFactory<?> factory = singletonFactories.get(name);
                if (factory != null) {
                    bean = factory.getObject(); // 获取早期引用
                    earlySingletonObjects.put(name, bean);
                }
            }
        }
        return bean;
    }
}
```

**面试回答**：  
Spring 通过三级缓存解决循环依赖：一级缓存存放完整 Bean，二级缓存存放早期 Bean 引用，三级缓存存放 Bean 工厂。当检测到循环依赖时，Spring 会通过提前暴露早期对象（尚未完成属性注入的 Bean 实例）来打破循环。如果仅解决循环依赖，二级缓存足够；但为支持 AOP 代理，需引入三级缓存。

---

## 7. 如何避免循环依赖？

**解决方案**：

1. **使用 @Lazy 注解**
```java
@Service
public class ServiceA {
    @Lazy
    @Autowired
    private ServiceB serviceB;
}
```

2. **重新设计代码结构**
```java
// 将共同逻辑提取到第三个服务中
@Service
public class CommonService {
    // 公共业务逻辑
}

@Service
public class ServiceA {
    @Autowired
    private CommonService commonService;
}

@Service
public class ServiceB {
    @Autowired
    private CommonService commonService;
}
```

3. **使用 setter 注入代替字段注入**
```java
@Service
public class ServiceA {
    private ServiceB serviceB;
    
    @Autowired
    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
```

**面试回答**：  
避免循环依赖的方法有：1) 使用 @Lazy 注解延迟加载依赖；2) 重新设计业务逻辑，提取公共逻辑到第三方服务；3) 使用 setter 注入代替字段注入。从根本上说，循环依赖通常是设计不合理导致的，应该优先考虑重新设计代码结构。

---

## 8. Spring 支持的事务管理类型

Spring 支持两种事务管理类型：编程式事务管理和声明式事务管理。

**示例说明**：
```java
// 编程式事务管理
@Service
public class UserService {
    
    @Autowired
    private PlatformTransactionManager transactionManager;
    
    public void createUser(User user) {
        TransactionStatus status = transactionManager.getTransaction(
            new DefaultTransactionDefinition());
        
        try {
            userRepository.save(user);
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}

// 声明式事务管理
@Service
public class OrderService {
    
    @Transactional
    public Order createOrder(Order order) {
        // 业务逻辑
        return orderRepository.save(order);
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateInventory(Order order) {
        // 更新库存
    }
}
```

**面试回答**：  
Spring 支持两种事务管理类型：1) 编程式事务管理，通过代码手动管理事务，灵活但繁琐；2) 声明式事务管理，通过 @Transactional 注解管理，业务与事务分离，推荐使用。声明式事务管理又支持多种传播行为，如 REQUIRED、REQUIRES_NEW 等。

---

## 9. Spring 的事务传播行为

Spring 定义了7种事务传播行为，常用的是 PROPAGATION_REQUIRED 和 PROPAGATION_REQUIRES_NEW。

**示例说明**：
```java
@Service
public class BusinessService {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private OrderService orderService;
    
    @Transactional
    public void completeOrder(Long userId, Order order) {
        // PROPAGATION_REQUIRED：如果当前没有事务就创建一个新事务
        User user = userService.getUser(userId);
        
        // PROPAGATION_REQUIRES_NEW：挂起当前事务，创建新事务
        orderService.processOrder(order);
        
        // PROPAGATION_NESTED：在当前事务中嵌套执行
        userService.updateUserStats(userId);
    }
}
```

**面试回答**：  
Spring 的事务传播行为定义了多个事务同时存在时的处理方式，常用的有：PROPAGATION_REQUIRED（如果当前没有事务就创建新事务，有则加入）、PROPAGATION_REQUIRES_NEW（总是创建新事务，挂起当前事务）、PROPAGATION_NESTED（在当前事务中嵌套执行）等。

---

## 10. Spring 事务在哪些场景下会失效？

**常见失效场景**：

1. **非 public 方法**
```java
@Service
public class UserService {
    
    @Transactional
    private void internalUpdate() { // 失效：必须是public
        // ...
    }
}
```

2. **自调用**
```java
@Service
public class UserService {
    
    public void createUser(User user) {
        validateUser(user);
        internalSave(user); // 事务失效：自调用
    }
    
    @Transactional
    public void internalSave(User user) {
        userRepository.save(user);
    }
}
```

3. **异常被捕获**
```java
@Service
public class OrderService {
    
    @Transactional
    public void processOrder(Order order) {
        try {
            orderRepository.save(order);
        } catch (Exception e) {
            // 异常被捕获，事务不会回滚
            log.error("Error saving order", e);
        }
    }
}
```

**解决方案**：
```java
@Transactional
public void processOrder(Order order) {
    try {
        orderRepository.save(order);
    } catch (Exception e) {
        log.error("Error saving order", e);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
```

**面试回答**：  
Spring 事务在以下场景会失效：1) 非 public 方法；2) 自调用（同类方法调用）；3) 异常被捕获未抛出；4) 抛出检查异常（默认只回滚非检查异常）。解决方案包括确保方法为 public、避免自调用、正确抛出异常，或在捕获异常后手动设置回滚。

---

## 11. 微服务中如何解决分布式事务？

微服务中常用 Seata 框架解决分布式事务问题，支持 AT、TCC 等模式。

**示例说明**：
```java
// 订单服务
@Service
public class OrderService {
    
    @GlobalTransactional // 开启全局事务
    public void createOrder(Order order) {
        // 1. 创建订单（本地事务）
        orderMapper.insert(order);
        
        // 2. 调用库存服务（远程服务）
        storageFeignClient.deduct(order.getProductId(), order.getCount());
        
        // 3. 调用账户服务（远程服务）
        accountFeignClient.debit(order.getUserId(), order.getMoney());
    }
}

// Seata 配置
@Configuration
public class SeataConfig {
    
    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("order-service", "my_test_tx_group");
    }
}
```

**面试回答**：  
微服务中解决分布式事务的方案有：1) 业务层面保持最终一致性，采用补偿机制（如 TCC）；2) 使用分布式事务框架如 Seata。Seata 支持 AT 模式（自动补偿）和 TCC 模式（手动补偿），可以根据业务场景选择合适的方式。

---

## 12. Seata 的 XA 和 AT 模式有什么区别？

| 特性       | XA 模式        | AT 模式            |
| ---------- | -------------- | ------------------ |
| 一阶段行为 | 不提交，锁资源 | 直接提交，不锁资源 |
| 回滚机制   | 依赖数据库回滚 | 通过数据快照回滚   |
| 一致性     | 强一致         | 最终一致           |

**面试回答**：  
Seata 的 XA 模式和 AT 模式主要区别在于：XA 模式一阶段不提交事务，锁定资源，依赖数据库机制实现回滚，保证强一致性；AT 模式一阶段直接提交，不锁定资源，利用数据快照实现回滚，保证最终一致性。

---

## 13. Spring Boot 自动装配原理

Spring Boot 自动装配通过 `@EnableAutoConfiguration` 和 `spring.factories` 文件实现。

**示例说明**：
```java
// 自定义自动配置
@Configuration
@ConditionalOnClass({DataSource.class, EmbeddedDatabaseType.class})
@EnableConfigurationProperties(DataSourceProperties.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class MyDataSourceAutoConfiguration {
    
    @Bean
    @ConditionalOnMissingBean
    public DataSource dataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }
}

// META-INF/spring.factories
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.example.MyDataSourceAutoConfiguration
```

**面试回答**：  
Spring Boot 自动装配原理：1) 通过 `@EnableAutoConfiguration` 开启自动配置；2) 通过 `SpringFactoriesLoader` 加载 `META-INF/spring.factories` 中的配置类；3) 配置类使用 `@Conditional` 条件注解按需加载；4) 需要引入对应的 `spring-boot-starter-xxx` 依赖。

---

## 14. Spring Boot 如何优雅停机？

优雅停机指服务关闭前处理完已接收请求。

**配置方式**：
```yaml
# application.yml
server:
  shutdown: graceful
spring:
  lifecycle:
    timeout-per-shutdown-phase: 30s
```

**实现示例**：
```java
// 自定义优雅停机处理
@Component
public class GracefulShutdown implements TomcatConnectorCustomizer {
    
    private volatile Connector connector;
    
    @Override
    public void customize(Connector connector) {
        this.connector = connector;
    }
    
    public void pause() {
        connector.pause();
        Executor executor = connector.getProtocolHandler().getExecutor();
        if (executor instanceof ThreadPoolExecutor) {
            try {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                threadPoolExecutor.shutdown();
                if (!threadPoolExecutor.awaitTermination(30, TimeUnit.SECONDS)) {
                    log.warn("Tomcat thread pool did not shut down gracefully");
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
```

**面试回答**：  
Spring Boot 优雅停机通过配置 `server.shutdown=graceful` 和 `spring.lifecycle.timeout-per-shutdown-phase` 实现。在收到停机信号后，Spring Boot 会停止接收新请求，等待正在处理的请求完成，超过超时时间后强制停机。

---

## 15. @Autowired 和 @Resource 的区别

| 特性         | @Autowired           | @Resource           |
| ------------ | -------------------- | ------------------- |
| 来源         | Spring 框架          | JSR-250（Java标准） |
| 查找顺序     | 先按类型，再按名称   | 先按名称，再按类型  |
| 支持参数数量 | 1个                  | 7个                 |
| 注入方式     | 构造器/Setter/属性   | Setter/属性         |
| IDEA 提示    | 注入 Mapper 可能报错 | 无报错              |

**示例说明**：
```java
@Service
public class UserService {
    
    // @Autowired 按类型注入
    @Autowired
    private UserRepository userRepository;
    
    // @Resource 按名称注入
    @Resource(name = "userRepository")
    private UserRepository userRepository;
    
    // @Autowired 用于构造器注入
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // @Resource 不能用于构造器注入
    @Resource
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```

**面试回答**：  
@Autowired 和 @Resource 的主要区别：1) 来源不同，@Autowired 来自 Spring，@Resource 来自 Java 标准；2) 查找顺序不同，@Autowired 先按类型再按名称，@Resource 先按名称再按类型；3) 注入方式支持不同，@Autowired 支持构造器注入，@Resource 不支持。

---

## 16. MyBatis 中 #{} 和 ${} 的区别

- `#{}`：预编译处理，防 SQL 注入，自动加引号
- `${}`：字符串拼接，易引发 SQL 注入，常用于动态表名/列名

**示例说明**：
```java
@Mapper
public interface UserMapper {
    
    // 安全：使用 #{} 防止SQL注入
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(@Param("username") String username);
    
    // 危险：使用 ${} 可能导致SQL注入
    @Select("SELECT * FROM users ORDER BY ${orderBy}")
    List<User> findAllOrderBy(@Param("orderBy") String orderBy);
    
    // 正确使用 ${} 的场景：动态表名
    @Select("SELECT * FROM ${tableName} WHERE id = #{id}")
    User findByIdFromTable(@Param("tableName") String tableName, 
                          @Param("id") Long id);
}
```

**面试回答**：  
MyBatis 中 #{} 和 ${} 的区别：1) #{} 是预编译处理，防止 SQL 注入，会自动加引号；2) ${} 是字符串拼接，可能引发 SQL 注入，常用于动态表名和列名。一般能用 #{} 就别用 ${}，若必须使用 ${}，需手工做好过滤防止 SQL 注入。

---

## 17. 分布式 Session 解决方案

常用分布式 Session 解决方案有 JWT Token 和 Cookie + Redis。

**示例说明**：
```java
@Service
public class TokenService {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    public String createToken(User user) {
        // 生成JWT
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS512, "secret")
                .compact();
        
        // 存储到Redis
        redisTemplate.opsForValue().set("token:" + token, user, 1, TimeUnit.HOURS);
        
        return token;
    }
    
    public User validateToken(String token) {
        try {
            // 验证JWT
            Claims claims = Jwts.parser()
                    .setSigningKey("secret")
                    .parseClaimsJws(token)
                    .getBody();
            
            // 从Redis获取用户信息
            User user = (User) redisTemplate.opsForValue().get("token:" + token);
            
            return user;
        } catch (Exception e) {
            throw new SecurityException("Invalid token");
        }
    }
}
```

**面试回答**：  
分布式 Session 的解决方案有：1) JWT Token，存储用户身份信息，其余信息存数据库/缓存；2) Cookie + Redis，Session 数据存 Redis，SessionID 返给客户端。JWT 方案无状态，适合分布式环境；Redis 方案性能高，可存储大量数据。

---

## 18. Feign 的底层实现原理

Feign 通过动态代理生成接口实现类，解析注解并构造 HTTP 请求。

**示例说明**：
```java
// 声明式Feign客户端
@FeignClient(name = "user-service", url = "${feign.client.user-service.url}")
public interface UserServiceClient {
    
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);
    
    @PostMapping("/users")
    User createUser(@RequestBody User user);
}

// 自定义配置
@Configuration
public class FeignConfig {
    
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    
    @Bean
    public Client feignClient() {
        return new ApacheHttpClient(); // 使用Apache HttpClient
    }
}

// 使用示例
@Service
public class OrderService {
    
    @Autowired
    private UserServiceClient userServiceClient;
    
    public Order createOrder(Order order) {
        User user = userServiceClient.getUserById(order.getUserId());
        // 处理订单逻辑
        return order;
    }
}
```

**面试回答**：  
Feign 的底层实现原理：通过动态代理生成接口实现类，解析注解并构造 HTTP 请求。默认使用 HttpURLConnection，可替换为 Apache HttpClient 或 OkHttp3 提升性能。Feign 整合了 Ribbon 实现负载均衡，整合 Hystrix 实现熔断降级。

---

这份整合后的面试题解析既包含了简洁的面试回答，又提供了详细的示例说明，可以帮助你更好地理解 Spring 框架的各个核心概念，并在面试中展示你的理解和实践经验。