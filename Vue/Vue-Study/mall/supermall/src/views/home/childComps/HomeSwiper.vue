<template>
  <swiper>
    <swiper-item v-for="item in banners" :key='item'>
      <a href="item.link">
        <img :src="item.image" alt="" @load="swiperLoad">
      </a>
    </swiper-item>
  </swiper>
</template>

<script>
import Swiper from 'components/common/swiper/Swiper'
import SwiperItem from 'components/common/swiper/SwiperItem'
export default {
  name: 'HomeSwiper',
  props: {
    banners: {
      type: Array,
      default () {
        return []
      }
    }
  },
  components: {
    SwiperItem,
    Swiper
  },
  methods: {
    swiperLoad () {
      this.$emit("swiperimgload");
    }
  }
}
</script>

<style scoped>

</style>
