<template>
  <div id="home">
    <nav-bar class="home-nav">
      <template v-slot:center><div>购物街</div></template>
    </nav-bar>
    <home-swiper :banners="banners"/>
    <recommend-view :recommends = "recommends"/>
    <feature-view/>
    <tab-control class="tab-control" :titles="[`流行`,`新款`,`精选`]" @tabclick="tabclick"/>
    <goods-list :goods="showGoods"/>

  </div>
</template>

<script>
// <!--封装的子组件-->
import HomeSwiper from './childComps/HomeSwiper'
import RecommendView from './childComps/RecommendView'
import FeatureView from './childComps/FeatureView'
// 公共组件
import NavBar from 'components/common/navbar/NavBar'
import TabControl from 'components/content/tabControl/TabControl'
import GoodsList from 'components/content/goods/GoodsList'
// 工具函数
import { getHomeMultidata, getHomeGoods } from 'network/home'

export default {
  name: 'Home',
  components: {
    NavBar,
    HomeSwiper,
    RecommendView,
    FeatureView,
    TabControl,
    GoodsList
  },
  data () {
    return {
      banners: [],
      recommends: [],
      goods: {
        pop: { page: 0, list: [] },
        new: { page: 0, list: [] },
        sell: { page: 0, list: [] }
      },
      currentType: 'pop'
    }
  },
  computed: {
    showGoods () {
      return this.goods[this.currentType].list
    }
  },
  methods: {
    /**
     * 事件监听相关方法
     *
     * */
    tabclick (index) {
      console.log(index)
      this.currentType = Object.keys(this.goods)[index]
    },
    /**
     * 网络请求相关的方法
     */
    getHomeMultidata () {
      getHomeMultidata().then(res => {
        this.banners = res.data.banner
        this.recommends = res.data.recommend
      })
    },
    getHomeGoods (type) {
      const page = this.goods[type].page + 1
      getHomeGoods(type, page).then(res => {
        this.goods[type].list.push(...res.data.list)
        this.goods[type].page += 1
      })
    }
  },
  // 组件创建好就请求数据
  created () {
    // 1、请求多个数据
    this.getHomeMultidata()

    // 2、请求商品数据
    this.getHomeGoods('pop')
    this.getHomeGoods('new')
    this.getHomeGoods('sell')
  }
}
</script>

<style scoped>
#home{
  padding-top: 44px;
}
.home-nav{
  background-color: var(--color-tint);
  color: white;

  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  z-index: 9;
}

.tab-control {
  /*position: relative;*/
  position: sticky;
  top: 44px;
  z-index: 9;
}

.tab-control2 {
  position: fixed;
  margin-top: -1px;
  width: 100%;
}
</style>
