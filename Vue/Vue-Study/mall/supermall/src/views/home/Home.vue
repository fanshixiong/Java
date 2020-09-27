<template>
  <div id="home">
    <nav-bar class="home-nav">
<!--      <div slot="center">购物街</div>-->
      <template v-slot:center><div>购物街</div></template>
    </nav-bar>

  </div>
</template>

<script>
import NavBar from 'components/common/navbar/NavBar'
import { getHomeMultidata } from 'network/home'

export default {
  name: 'Home',
  components: {
    NavBar
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
