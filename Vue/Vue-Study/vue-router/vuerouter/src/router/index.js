import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Help from '../views/Help.vue'
import User from '../views/User.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    // redirect: '/Home'
    meta: {
      title: '首页'
    },
    children: [
      // {
      //   path: '',
      //   redirect: '/home/news'//缺省时候重定向到/home/news
      // },
      {
        path: 'page',
        meta: {
          title: 'Page'
        },
        component: () => import('../views/HomePage')
      },
      {
        path: 'message',
        meta: {
          title: 'Message'
        },
        component: () => import('../views/HomeMessage')
      }
    ]
  },
  {
    path: '/about',
    name: 'About',
    meta: {
      title: '关于'
    },
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // 懒加载，引用的时候再使用，不用在开始的时候将所有的js文件全部加载，造成出现短暂空白页面
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/help',
    name: 'Help',
    meta: {
      title: '帮助'
    },
    component: Help
  },
  {
    path: '/user/:userId',
    name: 'User',
    meta: {
      title: '用户'
    },
    component: User
  },
  {
    path: '/profile',
    name: 'Profile',
    meta: {
      title: '档案'
    },
    component: () => import('../views/Profile.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
  // mode: 'history' // 修改模式为history
})

router.beforeEach((to, from, next) => {
  document.title = to.matched[0].meta.title // 给目标路由的页面的title赋值
  next() // 必须调用，不调用不会跳转
})

export default router
