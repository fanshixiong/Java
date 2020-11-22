// main.js中
import mitt from 'mitt'
import { createApp } from 'vue'

const app = createApp({}) // 正常配置
// 挂载事务总线
app.config.globalProperties.$bus = new mitt()




// 在组件A中使用事务总线触发某个动作
this.$bus.emit('EVENTTYPE');

// 在组件B中监听动作的发生
this.$bus.on('EVENTTYPE',()=>{
  console.log('EVENTTYPE发生了')})
