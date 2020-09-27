<template>
  <div id="home">
    <nav-bar class="home-nav">
      <template v-slot:center><div>购物街</div></template>
    </nav-bar>
    <home-swiper :banners="banners"/>
    <recommend-view :recommends = "recommends"/>
  </div>
</template>

<script>
import NavBar from 'components/common/navbar/NavBar'
import HomeSwiper from './childComps/HomeSwiper'
import RecommendView from './childComps/RecommendView'

import { getHomeMultidata } from 'network/home'

export default {
  name: 'Home',
  components: {
    NavBar,
    HomeSwiper,
    RecommendView
  },
  data () {
    return {
      banners: [],
      recommends: []
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
.home-nav{
  background-color: var(--color-tint);
  color: white;
}
</style>
