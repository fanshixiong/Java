import Vue from 'vue'
import VueRouter from 'vue-router'
import Detail from "../views/detail/Detail";

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    redirect:'/home'
  },
  {
    path:'/home',
    component:()=>import('views/home/Home'),
    meta:{
      title:'首页'
    }
  },
  {
    path:'/category',
    component:()=>import('views/category/Category'),
    meta:{
      title:'分类'
    }
  },
  {
    path:'/shopCart',
    component:()=>import('views/shoppingCart/ShoppingCart'),
    meta:{
      title:'购物车'
    }
  },
  {
    path:'/profile',
    component:()=>import('views/profile/Profile'),
    meta:{
      title:'档案'
    }
  },
  {
    path: '/detail/:iid',
    component:()=>import('views/detail/Detail'),
    meta: {
      title: '商品详情'
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

//导航守卫
router.beforeEach((to,from,next)=>{
  //修改标题
  document.title=to.matched[0].meta.title;
  next();
});

export default router
