<template>
  <div id="home">
    <nav-bar class="home-nav">
      <template v-slot:center><div>购物街</div></template>
    </nav-bar>
    <home-swiper :banners="banners"/>
    <recommend-view :recommends = "recommends"/>
    <feature-view/>
    <tab-control class="tab-control" :titles="[`流行`,`新款`,`精选`]" />

  </div>
</template>

<script>
import HomeSwiper from './childComps/HomeSwiper'
import RecommendView from './childComps/RecommendView'
import FeatureView from './childComps/FeatureView'

import NavBar from 'components/common/navbar/NavBar'
import TabControl from 'components/content/tabControl/TabControl'

import { getHomeMultidata } from 'network/home'

export default {
  name: 'Home',
  components: {
    NavBar,
    HomeSwiper,
    RecommendView,
    FeatureView,
    TabControl
  },
  data () {
    return {
      banners: [],
      recommends: [],
      goods: {
        'pop': {page: 0, list: []},
        'news': {page: 0, list: []},
        'sell': {page: 0, list: []}
      }
    }
  },
  created () {
    getHomeMultidata().then(res => {
      this.banners = res.data.banner
      this.recommends = res.data.recommend
    })
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
