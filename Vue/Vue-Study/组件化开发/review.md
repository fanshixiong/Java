## 计算属性

### 1.1 计算属性的本质

*   fullname:{set(), get()}

### 1.2 计算属性和methods对比

*   计算属性在多次使用时，只会调用一次，
*   有缓存

## 事件监听

### 2.1 基本使用



### 2.2 参数问题

*   btnClick
*   btnClick(event)
*   btnClick(abc, event) -> $event



### 2.3 修饰符

*   stop
*   prevent
*   .enter
*   .once
*   .native

## 条件判断

### 3.1 v-if/v-else-if/v-else



### 3.2 登录案例



### 3.3 v-show



## 循环遍历

### 4.1 遍历数组



### 4.2 遍历对象

*   value
*   value, key
*   value, key, index



### 4.3 响应式方法



### 4.4 作业



## 书籍案例



## v-model 使用



## 组件化开发

### 7.1 基本使用



### 7.2 全局组件和局部组件



### 7.3 父组件和子组件



### 7.4 注册的语法糖



### 7.5 模板分类写法

*   script
*   template



### 7.6 数据的存放

*   子组件不能直接访问父组件
*   子组件有自己的data，并且是一个函数
*   为什么是一个函数



### 7.7 父子组件的通信

*   父传子： props
*   子传父：$emit