# RabbitMQ工作模式

* RabbitMQ提供了**多种工作模式**：简单模式，work模式 ，Publish/Subscribe发布与订阅模式，Routing路由模式，Topics主题模式等

![image-20240806102313708](assets/image-20240806102313708.png)

官网对应模式介绍：https://www.rabbitmq.com/getstarted.html 

# **1 Work queues工作队列模式**

## **1.1 模式说明**

![image-20240806084946234](assets/image-20240806084946234.png) 

Work Queues与入门程序的简单模式相比，多了一个或一些消费端，多个消费端共同消费同一个队列中的消息。

**应用场景**：对于 任务过重或任务较多情况使用工作队列可以提高任务处理的速度



## 1.2 工作队列模式代码

### 1.2.1 生产者代码
```java
public static final String EXCHANGE_DIRECT = "";
public static final String ROUTING_KEY_WORK = "atguigu.queue.work";

@Test
public void testSendMessageWork() {
    for (int i = 0; i < 10; i++) {
        rabbitTemplate.convertAndSend(
                EXCHANGE_DIRECT,
                ROUTING_KEY_WORK,
                "Hello atguigu " + i);
    }
}
```



* **发送消息效果**

![image-20240725203346015](./assets/image-20240725203346015.png)



![image-20240725203322613](./assets/image-20240725203322613.png)



### 1.2.2 消费者代码

#### ①创建模块，配置POM

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.5</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
</dependencies>
```



#### ②YAML

```yaml
spring:
  rabbitmq:
    host: 192.168.47.100
    port: 5672
    username: guest
    password: 123456
    virtual-host: /
server:
  port: 10000
```



#### ③主启动类

仿照生产者工程的主启动类，改一下类名即可

```java
package com.atguigu.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMQConsumerMainType {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConsumerMainType.class, args);
    }

}
```



#### ④监听器

```java
package com.atguigu.mq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener {
    
    @Value("${server.port}")
    private String serverPort;

    @RabbitListener(queues = {"atguigu.queue.work"})
    public void processMessage(String messageContent, Message message, Channel channel) {
        System.out.println("Server Port:" + serverPort + " Message Content:" + messageContent);
    }

}
```



### 1.2.3 运行效果

#### ①消费端A

> Server Port:10000 Message Content:Hello atguigu 0
> Server Port:10000 Message Content:Hello atguigu 2
> Server Port:10000 Message Content:Hello atguigu 4
> Server Port:10000 Message Content:Hello atguigu 6
> Server Port:10000 Message Content:Hello atguigu 8



#### ②消费端B

> Server Port:20000 Message Content:Hello atguigu 1
> Server Port:20000 Message Content:Hello atguigu 3
> Server Port:20000 Message Content:Hello atguigu 5
> Server Port:20000 Message Content:Hello atguigu 7
> Server Port:20000 Message Content:Hello atguigu 9



# **2 订阅模式类型**

订阅模式示例图：

![image-20240806085107277](assets/image-20240806085107277.png) 

前面2个案例中，只有3个角色：

· P：生产者，也就是要发送消息的程序

· C：消费者：消息的接受者，会一直等待消息到来。

· queue：消息队列，图中红色部分

而在订阅模型中，多了一个exchange角色，而且过程略有变化：

· P：生产者，也就是要发送消息的程序，但是不再发送到队列中，而是发给X（交换机）

· C：消费者，消息的接受者，会一直等待消息到来。

· Queue：消息队列，接收消息、缓存消息。

· Exchange：交换机，图中的X。一方面，接收生产者发送的消息。另一方面，知道如何处理消息，例如递交给某个特别队列、递交给所有队列、或是将消息丢弃。到底如何操作，取决于Exchange的类型。

**Exchange有常见以下3种类型**：

o Fanout：广播，将消息交给所有绑定到交换机的队列

o Direct：定向，把消息交给符合指定routing key 的队列

o Topic：通配符，把消息交给符合routing pattern（路由模式） 的队列

**Exchange（交换机）只负责转发消息，不具备存储消息的能力**，因此如果没有任何队列与Exchange绑定，或者没有符合路由规则的队列，那么消息会丢失！



# 3 Publish/Subscribe发布订阅模式

## 3.1 模式说明

![image-20240806085123819](assets/image-20240806085123819.png) 

发布订阅模式：
1、每个消费者监听自己的队列。
2、生产者将消息发给broker，由交换机将消息转发到绑定此交换机的每个队列，每个绑定交换机的队列都将接收
到消息



## 3.2 代码实现

### 1 创建组件

* 名称列表

| 组件   | 组件名称                                           |
| ------ | -------------------------------------------------- |
| 交换机 | atguigu.exchange.fanout                            |
| 队列   | atguigu.queue.fanout01<br />atguigu.queue.fanout02 |



### 2 创建交换机

<span style="color:blue;">**注意**</span>：发布订阅模式要求交换机是Fanout类型

![image-20240725210428356](./assets/image-20240725210428356.png)

![image-20240725210526288](./assets/image-20240725210526288.png)



### 3 创建队列并绑定交换机

![image-20240725210906899](./assets/image-20240725210906899.png)



![image-20240725211118200](./assets/image-20240725211118200.png)



此时可以到交换机下查看绑定关系：

![image-20240725211206904](./assets/image-20240725211206904.png)

### 4 生产者代码

```java
public static final String EXCHANGE_FANOUT = "atguigu.exchange.fanout";

@Test
public void testSendMessageFanout() {
    rabbitTemplate.convertAndSend(EXCHANGE_FANOUT, "", "Hello fanout ~");
}
```



### 5 消费者代码

两个监听器可以写在同一个微服务中，分别监听两个不同队列：

```java
package com.atguigu.mq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener {

    @RabbitListener(queues = {"atguigu.queue.fanout01"})
    public void processMessage01(String messageContent, Message message, Channel channel) {
        System.out.println("Consumer01 Message Content:" + messageContent);
    }

    @RabbitListener(queues = {"atguigu.queue.fanout02"})
    public void processMessage02(String messageContent, Message message, Channel channel) {
        System.out.println("Consumer02 Message Content:" + messageContent);
    }

}
```



### 6 运行效果

先启动消费者，然后再运行生产者程序发送消息：

![image-20240725212632041](./assets/image-20240725212632041.png)



## 3.3 小结

交换机需要与队列进行绑定，绑定之后；一个消息可以被多个消费者都收到。

**发布订阅模式与工作队列模式的区别：**

- 工作队列模式本质上是绑定默认交换机
- 发布订阅模式绑定指定交换机
- 监听同一个队列的消费端程序彼此之间是竞争关系
- 绑定同一个交换机的多个队列在发布订阅模式下，消息是广播的，每个队列都能接收到消息



# 4 Routing路由模式

## 4.1 模式说明

路由模式特点：

· 队列与交换机的绑定，不能是任意绑定了，而是要指定一个RoutingKey（路由key）

· 消息的发送方在 向 Exchange发送消息时，也必须指定消息的 RoutingKey。

· Exchange不再把消息交给每一个绑定的队列，而是根据消息的Routing Key进行判断，只有队列的Routingkey与消息的 Routing key完全一致，才会接收到消息

![image-20240806085148987](assets/image-20240806085148987.png) 

图解：

· P：生产者，向Exchange发送消息，发送消息时，会指定一个routing key。

· X：Exchange（交换机），接收生产者的消息，然后把消息递交给 与routing key完全匹配的队列

· C1：消费者，其所在队列指定了需要routing key 为 error 的消息

· C2：消费者，其所在队列指定了需要routing key 为 info、error、warning 的消息



## 4.2 代码实现

### 1 创建组件

* 组件清单

没有特殊设置，名称外的其它参数都使用默认值：

| 组件   | 组件名称                 |
| ------ | ------------------------ |
| 交换机 | atguigu.exchange.direct  |
| 路由键 | atguigu.routing.key.good |
| 队列   | atguigu.queue.direct     |



### 2 绑定

![image-20240725214547261](./assets/image-20240725214547261.png)

![image-20240725214608820](./assets/image-20240725214608820.png)



### 3 生产者代码

```java
public static final String EXCHANGE_DIRECT = "atguigu.exchange.direct";

public static final String ROUTING_KEY_GOOD = "atguigu.routing.key.good";

@Test
public void testSendMessageRouting() {
    rabbitTemplate.convertAndSend(EXCHANGE_DIRECT, ROUTING_KEY_GOOD, "Hello routing ~");
}
```



### 4 消费者代码

```java
@RabbitListener(queues = {"atguigu.queue.direct"})
public void processMessageRouting(String messageContent, Message message, Channel channel) {
    System.out.println("Message Content:" + messageContent);
}
```



### 5 运行结果

![image-20240725215245500](./assets/image-20240725215245500.png)



# 5 Topics通配符模式

## **5.1. 模式说明**

Topic类型与Direct相比，都是可以根据RoutingKey把消息路由到不同的队列。只不过Topic类型Exchange可以让队列在绑定Routing key 的时候**使用通配符**！

Routingkey 一般都是有一个或多个单词组成，多个单词之间以”.”分割，例如： item.insert

通配符规则：

\#：匹配零个或多个词

*：匹配不多不少恰好1个词

举例：

item.#：能够匹配item.insert.abc 或者 item.insert

item.*：只能匹配item.insert

![image-20240806085214905](assets/image-20240806085214905.png) 

![img](assets/wps14.jpg) 

图解：

· 红色Queue：绑定的是usa.# ，因此凡是以 usa.开头的routing key 都会被匹配到

· 黄色Queue：绑定的是#.news ，因此凡是以 .news结尾的 routing key 都会被匹配



## 5.2 代码实现

### 1 创建组件

* 组件清单

| 组件   | 组件名称                                       |
| ------ | ---------------------------------------------- |
| 交换机 | atguigu.exchange.topic                         |
| 路由键 | #.error<br />order.*<br />\*.\*                |
| 队列   | atguigu.queue.message<br />atguigu.queue.order |



### 2 创建交换机

![image-20240725220957833](./assets/image-20240725220957833.png)



### 3 绑定关系

![image-20240725222339828](./assets/image-20240725222339828.png)

![image-20240725222805072](./assets/image-20240725222805072.png)



### 4 生产者代码

```java
public static final String EXCHANGE_TOPIC = "atguigu.exchange.topic";
public static final String ROUTING_KEY_ERROR = "#.error";
public static final String ROUTING_KEY_ORDER = "order.*";
public static final String ROUTING_KEY_ALL = "*.*";

@Test
public void testSendMessageTopic() {
    rabbitTemplate.convertAndSend(EXCHANGE_TOPIC, "order.info", "message order info ...");
    rabbitTemplate.convertAndSend(EXCHANGE_TOPIC, "goods.info", "message goods info ...");
    rabbitTemplate.convertAndSend(EXCHANGE_TOPIC, "goods.error", "message goods error ...");
}
```



### 5 消费者代码

```java
package com.atguigu.mq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener {

    @RabbitListener(queues = {"atguigu.queue.message"})
    public void processMessage01(String messageContent, Message message, Channel channel) {
        System.out.println("Queue Message:" + messageContent);
    }

    @RabbitListener(queues = {"atguigu.queue.order"})
    public void processMessage02(String messageContent, Message message, Channel channel) {
        System.out.println("Queue Order:" + messageContent);
    }

}
```



### 6 运行效果

![image-20240725223737173](./assets/image-20240725223737173.png)



# 6 模式总结

## **1、简单模式 HelloWorld**

一个生产者、一个消费者，不需要设置交换机（使用默认的交换机）

![image-20240806085244893](assets/image-20240806085244893.png) 



## **2、工作队列模式 Work Queue**

一个生产者、多个消费者（竞争关系），不需要设置交换机（使用默认的交换机）

![image-20240806085305207](assets/image-20240806085305207.png) 



## **3、发布订阅模式 Publish/subscribe**

需要设置类型为fanout的交换机，并且交换机和队列进行绑定，当发送消息到交换机后，交换机会将消息发送到绑定的队列

![image-20240806085325073](assets/image-20240806085325073.png) 



## **4、路由模式 Routing**

需要设置类型为direct的交换机，交换机和队列进行绑定，并且指定routing key，当发送消息到交换机后，交换机会根据routing key将消息发送到对应的队列

 ![image-20240806085354471](assets/image-20240806085354471.png)



## **5、通配符模式 Topic**

需要设置类型为topic的交换机，交换机和队列进行绑定，并且指定通配符方式的routing key，当发送消息到交换机后，交换机会根据routing key将消息发送到对应的队列

 ![image-20240806085413115](assets/image-20240806085413115.png)
