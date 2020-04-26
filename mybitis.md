### mybitis

### **一、简单题**

#### 1、Mybatis动态sql是做什么的？都有哪些动态sql？简述一下动态sql的执行原理？

#### 答：

​	1.Mybatis 动态 SQL ，可以让我们在 XML 映射文件内，添加条件判断标签，达到动态拼接 SQL 的功能。

​	2.Mybatis 提供了 9 种动态 SQL 标签，如下：trim、where、set、foreach、if、choose、when、 					        		otherwise、bind；

​	3.动态 SQL 执行原理为，内部使用 **OGNL** 的表达式，从 SQL 参数对象中计算表达式的值，根据表达式的值动		态拼接 SQL ，以此来完成动态 SQL 的功能。

#### 2、Mybatis是否支持延迟加载？如果支持，它的实现原理是什么？

#### 答：

​	1.Mybatis 仅支持 association 关联对象和 collection 关联集合对象的延迟加载，association 指的就是一对一，collection 指的就是一对多查询。在MyBatis配置文件中，可以配置是否启用延迟加载lazyLoadingEnabled=true|false。

​	2.它的原理是，使用 CGLIB 创建目标对象的代理对象，当调用目标方法时，进入拦截器方法，比如调用 a.getB().getName()，拦截器 invoke() 方法发现 a.getB() 是 null 值，那么就会单独发送事先保存好的查询关联 B 对象的 SQL，把 B 查询上来，然后调用 a.setB(b)，于是 a 的对象 b 属性就有值了，接着完成 a.getB().getName() 方法的调用。这就是延迟加载的基本原理。

#### 3、Mybatis都有哪些Executor执行器？它们之间的区别是什么？

#### 答：

Mybatis 有 3 种基本的执行器（Executor）：

1. SimpleExecutor：每执行一次 update 或 select，就开启一个 Statement 对象，用完立刻关闭 Statement 对象；

2. ReuseExecutor：执行 update 或 select，以 SQL 作为 key 查找 Statement 对象，存在就使用，不存在就创建，用完后，不关闭 Statement 对象，而是放置于 Map 内，供下一次使用。简言之，就是重复使用 Statement 对象；

3. BatchExecutor：执行 update（没有 select，JDBC 批处理不支持select），将所有 SQL 都添加到批处理中（addBatch()），等待统一执行（executeBatch()），它缓存了多个 Statement 对象，每个 Statement对 象都是 addBatch() 完毕后，等待逐一执行 executeBatch() 批处理。与 JDBC 批处理相同。

#### 4、简述下Mybatis的一级、二级缓存（分别从存储结构、范围、失效场景。三个方面来作答）？

#### 答：

​	1.存储结构：一级缓存的底层数据结构是一个HashMap。二级缓存的底层数据结构也是一个HashMap。

​	2.范围：一级缓存是session级别的缓存,也称本地缓存,是一直开启的；二级缓存是mapper级别的缓存，是跨	  	SqlSession的。

​	3.失效场景

​	a. sqlsession变了 缓存失效

​	b. sqlsession不变,查询条件不同，一级缓存失效

​	c. sqlsession不变,中间发生了增删改操作，一级缓存失败

​	d. sqlsession不变,手动清除缓存，一级缓存失败

#### 5、简述Mybatis的插件运行原理，以及如何编写一个插件？

#### 答：

1.Mybatis仅可以编写针对四种接口的插件，分别是ParameterHandler、ResultSetHandler、StatementHandler、Executor。Mybatis使用JDK的动态代理，为需要拦截的接口生成代理对象，以实现接口方法拦截功能，每当执行这四种接口对象的方法时，就会进入指定的拦截方法。

2.实现Mybatis的Interceptor接口并复写intercept()方法，然后再给插件编写注解，指定需要拦截的接口方法即可。最后，在配置文件中对自定义插件进行配置。后在给插件编写注解，指定要拦截哪一个接口的哪	些方法即可，需要在配置文件中配置你编写的插件

**二、编程题**

请完善自定义持久层框架IPersistence，在现有代码基础上添加、修改及删除功能。【需要采用getMapper方式】

代码地址：https://github.com/Jaingqin/lagou.git



