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
export default {
  name: 'Home',
  components: {
    NavBar
  }
}
</script>

<style scoped>
.home-nav{
  background-color: var(--color-tint);
  color: white;
}
</style>
