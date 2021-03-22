package com.spring_1_100.test_91_100.test98_threadlocal;

import java.sql.Connection;
import java.sql.Statement;

public class TopDao {
    // 使用ThreadLocal保存Connection变量
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    /*
     不同的线程在使用topicDao时，先判断connThreadLocal.get()是否为空，如果为空，则说明当前线程还没有对应的Connection对象，这时创建
     一个Connection对象并添加到本地线程中，如果不为null ,则说明当前线己经拥有了Connection对象了，直接使用就可了，这样，就保证了不同
     的线程使用相关的Connection，而不会使用其他的线程中的Connection ，因此，这个TopicDao就可以做到sinleton共享了。
     我们将详细的通过ThreadLocal来解决线程问题
     Spring为事务管理提供了编程模版，高层次建立了一个统一的事务抽象，也就是说，不管选择Spring JDBC ,Hibernate ,JPA 还是Ibatis ,
     Spring 都主上我们可以用统一的编程模型进行事务管理。
     像Spring Dao 为不同的持久化实现提供模版一样，Spring 事务管理继承这一风格，也提供了事务模版类TransactionTemplate,通过TransactionTemplate
     并配合使用事务回调TransactionCallBack指定具体的持久化操作就可以通过编程方式实现事务管理而无须关注资源获取，复用，释放，事务同步和
     异常处理的操作。
     Spring 事务管理的亮点在于声明工事务管理，Spring 允许通过声明方式，在IOC配置中指定事务的边界和事务的属性，Spring 自动在指定事务边界上应用事务的
     属性，声明式事务是EJB炫耀一时的,Spring 让这种技术平民化，甚至Spring 的声明事务比EJB更加的强大
     EJB事务建立在JTA的甚而上，而JTA又必需通过JNDI获取，这意味着，不管用户是应用是跨数据源的应用，还是单数据源的应用，EJB都要求使用全局
     事务的方式以处理，这意味着基于EJB 的应用无法脱离应用服务器所提供的容器环境，这种不加区别的一概而论的做法无异于杀鸡用牛刀。
     Spring深刻的认识到，大部分应用都是基于单数据源的，只有为数不多的应用需要使用到多数据源的JTA事务，因此，在单数据源的情况下，Spring
     直接使用底层服务器的支持，通过引用应用服务器的JNDI 资源完成JTA事务，Spring 让人印象深刻的地方在于不管用户使用体积持久化实现技术，
     也不管用户是否使用了JTA事务，都可以采用相同的事务管理模型，这种统一的处理方式所带来的好处是不可估量的，用户完全可以抛出事务管理的问题
     编写程序，并在Spring中通过配置完成事务的管理工作 。
     TransactionDefinition 用于描述事务的隔离级别，超时时间，是否为只读事务传播规则等控制事务具体的行为的事务属性，这些事务属性可以通过
     XML配置或者注解描述提供，也可以通过手工编程的方式设置
     PlatformTransactionManager 根据TransactionDefinition 提供的事务属性配置信息，创建事务，并用TransactionStatus 描述这个激活的
     事务状态，下面，我们分别来了这些SPI接口内部的组成部分
     TransactionDefinition 定义了Spring兼容的事务属性，这些属性对事务管理控制的若干方面进行配置
     事务隔离：当前事务和其他的事务的隔离的程度，在TransactionDefinition接口中，定义了和java.sql.Connection 接口中同名的4个隔离级别
     ISOLATION_READ_UNCOMMITIED ,ISOLATION_READ_COMMITED,ISOLATION_REPEATABLE_READ,ISOLATION_SERIALIZABLE 实际上它直接使用Connection
     的同名常量TransactionDefinition还定义了一个默认的隔离级别。ISOLATION_DEFAULT, 它们表示使用底层数据库的默认隔离级别
     事务传播，通常在一个事务中执行的所有的代码都会在运行于同一事务上下文中运行，但是Spring也提供了几个可选的事务传播类型，例如，简单的参与
     到现有的事务中，或者挂起当前的事务，创建一个新的事务，在Spring事务管理中，传播行为是一个重要概念，我们将单独的在，Spring 提供了
     EJB CMT 所支持的事务传播类型
     事务超时，事务在超时前能运行多久，超时时间后，事务被回流，有些事务管理器不支持事务过期的功能，这时，如果设置TIMEOUT_DEFAULT之外 的其他的值时
     将抛出异常
     只读状态，只读事务不修改任何数据，数据事务管理者可以针对 可读事务应用一些优化措施，提交运行性能，只读事务在某些情况下使用Hibernate
     是一种非常有用的优化，试图在只读事务中更改数据将引发异常
     TransactionStatus
     TransactionStatus 代表一个事务的具体运行状态，事务管理器通过该接口获取事务的运行期状态信息，也可以通过该接口间接了回流事务，它相比于其他的
     抛出异常时回流事务的方式更加可控性，该接口继承于SavepointManager接口,SavepointManager接口基于JDBC 3.0 保存点分段事务控制能力
     提供了嵌套事务的机制
     其中SavepointManager 接口拥有以下方法
     Object createSavepoint ()
     创建一个保存点对象，以便在后面可利用rollbackToSavepoint(Object savepoint ) 方法 ，使事务回滚到特定的保存点上，也可以通过releaseSavePoint()
     释放一个己经存在的不用保存点
     void rollbackToSavepoint(Object savepoint)
     将事务回滚到特定保存点上，被回滚的保存点将自动释放
     void releaseSavepoint(Object savepoint)
     释放一个保存点，如果事务提交，所有的保存点会被自动释放，无须手工清除
     这3个方法在底层的资源不支持点时，都将抛出Nested Transaction NotSupported Exception 异常
     Transaction扩展了SavepointManager 并提供了以下的方法
     boolean hasSavepoint()
     当前的事务是否在内存创建一个保存点，保存点为了支持Spring 嵌套事务而创建的
     boolean isNewTransaction()
     判断当前的事务是否是一个新的事务，如果返回false ,表示当前事务是一个己经存在的事务，或者当前操作未运行在事务环境中。
     boolean isCompleted()
     当前的事务是否己经结束，己经提交或者回滚
     boolean isRollBackOnly()
     当前事务是否己经被标识为结束，己经提交或者回滚
     void setRollbackOnly()
     将当前的事务设置为rollback-only ，通过该标识通知事务管理只能将事务回滚，事务管理器将通过显示 的调用回滚命令或者抛出异常的方式回滚
     事务
     PlatformTransactionManager
     通过JDBC的事务管理知识，我们知道事务只能被提交或者回滚（或回滚到某个保存点后提交，）Spring 高层事务抽象接口org.springframework.transaction.PlatformTransactionManager
     很好的描述事务管理的概念
      PlatformTransactionManager定义了3个接口方法，它们是SPI(Service provide Interface ) 高层次的接口方法，这些访问都没有JNDI,绑定在一起
      可以像Spring容器一中的普通 的bean一样，对待PlatformTransactionManager 的实现者一样。
      下面我们来了解    PlatformTransactionManager 方法的功能
      TransactionStatus getTransaction(TransactionDefinition definition)
      该方法根据事务定义信息从事务环境中返回一个己经存在的事务，或者创建一个新的事务，并用TransactionStatus 描述这个事务的状态
      commit(TransactionStatus status )
      根据事务的状态提交事务，如果事务状态己经被标识为rollback-only  ，该方法将执行一个回滚事务操作
      rollback(Transaction status )
      将事务回滚，当commit() 方法抛出异常时，rollback()将会被隐式的调用
      Spring的事务管理器的实现
      Spring 将事务管理委托给了底层持久化的框架完成，因此，Spring为不同的持久化框架提供了PlatformTransactionManager 接口的实现类
      org.springframework.orm.jpa.JpaTransactionManager : 使用JPA 进行持久化，使用该事务管理器
      org.springframework.orm.hibernate3.HibernateTransactionManger : 使用Hibernate3.HibernateTransactionManager 使用Spring
      JDBC 或者ibatis等基于DataSource数据源的持久化技术时，使用该事务管理器。
      org.springframework.jdbc.datasource.DatasourceTransactionManager : 使用Spring jdbc 或者iBatis 等基于Datasource
      数据源的持久化技术时，使用该事务管理器
      org.springframework.orm.jdo.JdoTransactionManager  使用JDO 进行持久化，使用该事务管理器
      org.springframework.transaction.jta.JtaTransactionManager 具有多个数据源的全局事务使用该事务管理器，不管采用体积持久化技术。
      这些事务处理器都是对特定的事务实现框架的代理，这样，我们就可以通过Spring所提交的高级抽象对不同的种类的事务实现使用相同的方式进行管理
      而不用关心具体的实现。
      要实现事务管理，首先要在Spring中配置好相应的事务管理器，为事务管理器指定数据资源以及一些其他的事务管理控制属性，下面我们看一下几个常见的
      事务管理器的配置。



     */
    public static Connection getConnection() {
        //如果connectionThreadLocal 没有本地对应的线程Connection创建一个新的Connection
        // 将将其保存到线程本地变量中
        if (connectionThreadLocal.get() != null) {
            Connection conn = null;
            connectionThreadLocal.set(conn);
            return conn;

        }
        // 直接返回线程本身对象
        return connectionThreadLocal.get();
    }

    public void addTopic() throws Exception {
        // 从ThreadLocal中获取线程对应的
        Statement stat = getConnection().createStatement();
    }

}
