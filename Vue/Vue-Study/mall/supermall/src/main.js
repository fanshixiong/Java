import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 自定义事件总线
// Vue.prototype.$bus = new Vue()

createApp(App).use(store).use(router).mount('#app')
