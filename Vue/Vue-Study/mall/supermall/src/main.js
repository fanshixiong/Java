import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Mitt from 'mitt'

const app = createApp(App)
app.use(store).use(router).mount('#app')
// 挂载事务总线
app.config.globalProperties.$bus = new Mitt()
