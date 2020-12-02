<template>
  <div id="home">
    <nav-bar class="home-nav">
      <template v-slot:center><div>购物街</div></template>
    </nav-bar>

    <div v-show="isShowRefreshMsg" class="refreshMsg">{{msg}}</div>
    <tab-control v-show="isTabFixed" class="tab-control tab-control2"
                 :titles="[`流行`,`新款`,`精选`]" @tabclick="tabClick" ref="tabControl1"/>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            @scroll="contentScroll"
            :pull-up-load="true"
            @pullingup = "loadMore"
            @pullingdown="homePullingDown"
            :pull-down-refresh=true>
      <home-swiper :banners="banners" @swiperimgload="swiperImgLoad"/>
      <recommend-view :recommends = "recommends"/>
      <feature-view/>
      <tab-control class="tab-control"
                   :titles="[`流行`,`新款`,`精选`]" @tabclick="tabClick" ref="tabControl2"/>
      <goods-list :goods="showGoods"/>
      <div class="refreshMsg" v-show="isShowBackTop">上拉加载更多</div>
    </scroll>
    <back-top @click = "backClick" v-show="isShowBackTop"/>

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
import Scroll from 'components/common/scroll/Scroll'
import BackTop from 'components/common/backTop/BackTop'
// 工具函数
import { getHomeMultidata, getHomeGoods } from 'network/home'
import { TOP_DISTANCE } from 'common/const'
import { debounce } from 'common/utils'

export default {
  name: 'Home',
  components: {
    HomeSwiper,
    RecommendView,
    FeatureView,
    NavBar,
    GoodsList,
    Scroll,
    BackTop,
    TabControl
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
      currentType: 'pop',
      msg: '↓下拉刷新',
      isMsg: true,
      isShowRefreshMsg: true,
      tabOffsetTop: 0,
      isTabFixed: false,
      saveY: 0,
      isShowBackTop: false
    }
  },
  computed: {
    showGoods () {
      return this.goods[this.currentType].list
    }
  },
  methods: {
    /**
     * 事件监听相关的方法
     */

    // 1、监听tabControl的点击,mixin里的tabClick发生点击事件并调用此方法
    tabClick (index) {
      switch (index) {
        case 0:
          this.currentType = 'pop'
          break
        case 1:
          this.currentType = 'new'
          break
        case 2:
          this.currentType = 'sell'
          break
      }
      this.$refs.tabControl1.currentIndex = index
      this.$refs.tabControl2.currentIndex = index
    },

    backClick () {
      this.$refs.scroll.scrollTo(0, 0, 500)
    },
    // 2、监听滚动的位置（使用scroll组件传过来的事件）
    contentScroll (position) {
      // 1)、改变上拉刷新时的文字
      if (this.isMsg && position.y > 40) {
        this.isMsg = false
        this.msg = '松开立即刷新'
      } else if (position.y <= 0) {
        this.msg = '↓下拉刷新'
        this.isMsg = true
        this.isShowRefreshMsg = false
      } else {
        this.isShowRefreshMsg = true
      }

      // 2)、监听BackTop是否显示
      this.isShowBackTop = position.y < -TOP_DISTANCE

      // 3)、判断tabControl是否需要吸顶显示
      this.isTabFixed = this.tabOffsetTop <= (-position.y)
    },

    // 3、监听上拉事件（使用scroll组件传过来的事件）
    loadMore () {
      this.getHomeGoods(this.currentType)
    },

    // 4、监听下拉事件（使用scroll组件传过来的事件）
    homePullingDown () {
      this.msg = '刷新中......'
      setTimeout(() => {
        this.msg = '刷新成功✔'
        // location.reload()
        window.location.href = 'http://app.huaxin.press'
      }, 500)
    },

    // 5、获取tabControl组件距离顶部的距离,所有的组件都有一个$el属性，用于拿到组件中的元素
    // 需要监听上半部分的图片加载完成
    swiperImgLoad () {
      this.tabOffsetTop = 0 // this.$refs.tabcontrol2.$el.offsetTop
    },

    /**
     * 网络请求相关的方法
     */
    getHomeMultidata () {
      // 1、请求多个数据
      console.log('getHomeMultidata')
      getHomeMultidata().then(res => {
        this.banners = res.data.banner.list
        this.recommends = res.data.recommend.list
      })
    },
    getHomeGoods (type) {
      // 2、请求商品数据
      console.log('getHomeGoods')
      const page = this.goods[type].page + 1
      getHomeGoods(type, page).then(res => {
        this.goods[type].list.push(...res.data.list)
        this.goods[type].page += 1
      })
    }
  },
  mounted () {
    // 1.图片加载的事件监听和防抖函数
    const refresh = debounce(this.$refs.scroll.refresh)
    this.$bus.on('itemimageload', () => {
      refresh()
    })
  },
  // 组件创建好就请求数据
  created () {
    // 1、请求多个数据
    this.getHomeMultidata()

    // 2、请求商品数据
    this.getHomeGoods('pop')
    this.getHomeGoods('new')
    this.getHomeGoods('sell')
  },
  // 进入本组件时触发
  activated () {
    // 一进入组件就滚动到离开时保存的位置
    this.$refs.scroll && this.$refs.scroll.scrollTo(0, this.saveY, 10)
    // refresh():重新计算 better-scroll,
    this.$refs.scroll && this.$refs.scroll.refresh()
  },
  // 离开本组件时触发
  deactivated () {
    // 1、保存离开时的位置
    this.saveY = this.$refs.scroll.getScrollY()

    // 2、取消全局事件的监听
    this.$bus.off('itemImageLoad', this.itemImgListener)
  }
}
</script>

<style scoped>
#home {
  margin-bottom: 49px;
  overflow: hidden;
}

.home-nav-bar {
  color: white;
  background-color: var(--color-tint);
}

.tab-control {
  position: relative;
  z-index: 9;
}

.tab-control2 {
  position: fixed;
  margin-top: -1px;
  width: 100%;
}

.content {
  position: relative;
  height: calc(100vh - 93px);
  overflow: hidden;
}

.refreshMsg {
  width: 100%;
  height: 40px;
  position: absolute;
  line-height: 40px;
  text-align: center;
  color: rgba(0, 0, 0, 0.5);
  font-style: oblique;
}
</style>
