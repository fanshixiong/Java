<template>
  <div id="app">
    <tab-bar>
      <tab-bar-item>
        <template v-slot:item-icon>
          <img src="./assets/img/tabbar/home.png" alt="" srcset="">
          <img src="./assets/img/tabbar/home_active.png" alt="" srcset="">
        </template>
        <template v-slot:item-icon-active>
          <img src="./assets/img/tabbar/home_active.png" alt="" srcset="">
        </template>
        <template v-slot:item-text>
          <div>首页</div>
        </template>
      </tab-bar-item>
      <tab-bar-item>
        <template v-slot:item-icon>
          <img src="./assets/img/tabbar/categories.png" alt="" srcset="">
          <img src="./assets/img/tabbar/categories_active.png" alt="" srcset="">
        </template>
        <template v-slot:item-icon-active>
          <img src="./assets/img/tabbar/categories_active.png" alt="" srcset="">
        </template>
        <template v-slot:item-text>
          <div>分类</div>
        </template>
      </tab-bar-item>
      <tab-bar-item>
        <template v-slot:item-icon>
          <img src="./assets/img/tabbar/shopcart.png" alt="" srcset="">
          <img src="./assets/img/tabbar/shopcart_active.png" alt="" srcset="">
        </template>
        <template v-slot:item-icon-active>
          <img src="./assets/img/tabbar/shopcart_active.png" alt="" srcset="">
        </template>
        <template v-slot:item-text>
          <div>购物车</div>
        </template>
      </tab-bar-item>
      <tab-bar-item>
        <template v-slot:item-icon>
          <img src="./assets/img/tabbar/profile.png" alt="" srcset="">
          <img src="./assets/img/tabbar/profile_active.png" alt="" srcset="">
        </template>
        <template v-slot:item-icon-active>
          <img src="./assets/img/tabbar/profile_active.png" alt="" srcset="">
        </template>
        <template v-slot:item-text>
          <div>我的</div>
        </template>
      </tab-bar-item>
    </tab-bar>
  </div>
</template>
<script>
import TabBar from './components/tabbar/TabBar'
import TabBarItem from './components/tabbar/TabBarItem'

export default {
  name: 'App',
  data () {
    return {

    }
  },
  components: {
    TabBar,
    TabBarItem
  },
  methods: {

  }
}
</script>
<style>
  @import './assets/css/base.css';

</style>
